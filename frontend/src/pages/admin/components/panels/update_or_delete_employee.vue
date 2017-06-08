<template>
    <div>
        <form class="form" @submit.prevent="query">
            <div class="form-group">
                <label for="profile_id">
                    雇员Id
                </label>
                <input id="profile_id" class="form-control" type="text" required>
            </div>
            <button class="btn btn-default form-control">查询</button>
        </form>
        <br>
        <br>
        <hr>
        <br>
        <br>
        <form @submit.prevent="login" class="form">
            <div class="form-group">
                <label for="profile_username">
                    雇员姓名
                </label>
                <input id="profile_username" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="profile_usertype">
                    雇员类型
                </label>
                <select id="profile_usertype" class="form-control" required>
                    <option value="hour">小时</option>
                    <option value="salary">受薪</option>
                    <option value="commission">委托</option>
                </select>
            </div>
            <div class="form-group">
                <label for="profile_tel">
                    电话号码
                </label>
                <input id="profile_tel" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="profile_salary_per_hour">
                    小时薪资
                </label>
                <input id="profile_salary_per_hour" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="profile_salary_fixed">
                    固定薪资
                </label>
                <input id="profile_salary_fixed" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="profile_salary_rate">
                    佣金率
                </label>
                <input id="profile_salary_rate" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="profile_hor_limit">
                    小时限制
                </label>
                <input id="profile_hor_limit" class="form-control" type="number" required>
            </div>
            <button class="btn btn-default form-control" type="submit">更新雇员信息</button>
        </form>
        <br>
        <br>
        <br>
        <hr>
        <button class="btn btn-danger form-control" @click="remove">删除雇员</button>
        <br>
        <br>
        <br>
    </div>
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
                login: function()
                {

                },
                query: function()
                {

                },
                remove: function()
                {

                }
            }
    }
</script>
<style scoped>

</style>