<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="login_account">
                账户
            </label>
            <input id="login_account" type="text" class="form-control">
        </div>
        <div class="form-group">
            <label for="login_password">
                密码
            </label>
            <input id="login_password" type="text" class="form-control">
        </div>
        <button class="btn btn-default form-control" type="submit">Login</button>
    </form>
</template>
<script>
    module.exports =
        {
            data: function ()
            {
                return {};
            },
            components: {},
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