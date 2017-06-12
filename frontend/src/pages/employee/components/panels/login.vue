<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="login_account">
                账户
            </label>
            <input v-model="account" id="login_account" type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="login_password">
                密码
            </label>
            <input v-model="password" id="login_password" type="password" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">登录</button>
    </form>
</template>
<script>
    export default
    {
        data: function () {
            return {
                account: null,
                password: null,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/login?account=${this.login_account}&password=${this.login_password}`;
                }
            },
        methods:
            {
                login: function()
                {
                    if(this.password === '00000000')
                    {
                        this.$store.commit('user/login', {uid: this.account});
                    }
                    else
                    {
                        alert('密码错误');
                    }
                    console.log(this.request_url);
                }
            }
    }
</script>
<style scoped>

</style>