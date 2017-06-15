<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="id">
                账户
            </label>
            <input v-model="id" id="id" type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="password">
                密码
            </label>
            <input v-model="password" id="password" type="password" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">登录</button>
    </form>
</template>
<script>
    import {get} from '../../../../vendor/utils.js';
    export default
    {
        data: function () {
            return {
                id: null,
                password: null,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/employee/login?id=${this.id}&password=${this.password}`;
                }
            },
        methods:
            {
                login: async function()
                {
                    let result = await get(this.request_url);
                    result = JSON.parse(result);
                    if(result.status === 'ok')
                    {
                        this.$store.commit('user/login', {uid: this.id});
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