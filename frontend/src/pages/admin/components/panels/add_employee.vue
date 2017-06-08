<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="new_profile_username">
                雇员姓名
            </label>
            <input id="new_profile_username" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="new_profile_usertype">
                雇员类型
            </label>
            <select id="new_profile_usertype" class="form-control" required>
                <option value="hour">小时</option>
                <option value="salary">受薪</option>
                <option value="commission">委托</option>
            </select>
        </div>
        <div class="form-group">
            <label for="new_profile_tel">
                电话号码
            </label>
            <input id="new_profile_tel" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="new_profile_salary_per_hour">
                小时薪资
            </label>
            <input id="new_profile_salary_per_hour" class="form-control" type="number" required>
        </div>
        <div class="form-group">
            <label for="new_profile_salary_fixed">
                固定薪资
            </label>
            <input id="new_profile_salary_fixed" class="form-control" type="number" required>
        </div>
        <div class="form-group">
            <label for="new_profile_salary_rate">
                佣金率
            </label>
            <input id="new_profile_salary_rate" class="form-control" type="number" required>
        </div>
        <div class="form-group">
            <label for="new_profile_hor_limit">
                小时限制
            </label>
            <input id="new_profile_hor_limit" class="form-control" type="number" required>
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