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
        <button class="btn btn-default form-control" type="submit">Login</button>
    </form>
</template>
<script>
    import {get} from '../../../../vendor/utils.js';
    export default
        {
            data:function()
            {
                return {
                    account: null,
                    password: null
                };
            },
            computed:
                {
                    request_url: function()
                    {
                        return`${this.$store.state.backend.base_url}/admin/login?id=${this.account}&password=${this.password}`;
                    }
                },
            methods:
                {
                    login: async function()
                    {
                        console.log(this.request_url);
                        let result = await get(this.request_url);
                        result = JSON.parse(result);

                        if(result.status === 'ok')
                        {
                            this.$store.commit('user/login', {uid: this.account});
                        }
                        else
                        {
                            alert('登录失败');
                        }
                    }
                }
        }
</script>
<style scoped>

</style>