<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="login_account">
                账户
            </label>
            <input v-model="login_account" id="login_account" type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="login_password">
                密码
            </label>
            <input v-model="login_password" id="login_password" type="password" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">Login</button>
    </form>
</template>
<script>
    module.exports =
        {
            data:function()
            {
                return {
                    login_account: null,
                    login_password: null
                };
            },
            generated:
                {
                    query_string: function()
                    {
                        return ``;
                    }
                },
            methods:
                {
                    login: function()
                    {

                    }
                }
        }
</script>
<style scoped>

</style>