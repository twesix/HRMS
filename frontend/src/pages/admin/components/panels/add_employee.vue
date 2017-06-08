<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="new_profile_username">
                雇员姓名
            </label>
            <input id="new_profile_username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="new_profile_usertype">
                雇员Id
            </label>
            <select id="new_profile_usertype" class="form-control">
                <option value="hourly">按小时付款</option>
            </select>
        </div>
        <button class="btn btn-default">添加雇员</button>
    </form>
</template>
<script>
    export default
    {
        data: function () {
            return {};
        },
        components: {},
        methods:
            {
                login()
                {

                }
            }
    }
</script>
<style scoped>

</style>