<template>
    <form @submit.prevent="submit" class="form" id="form">
        <div class="form-group">
            <label for="username">
                雇员姓名
            </label>
            <input v-model="username" id="username" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="usertype">
                雇员类型
            </label>
            <select v-model="usertype" id="usertype" class="form-control" required>
                <option value="hour">小时</option>
                <option value="salary">受薪</option>
                <option value="commission">委托</option>
            </select>
        </div>
        <div class="form-group">
            <label for="tel">
                电话号码
            </label>
            <input v-model="tel" id="tel" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="salary_per_hour">
                小时薪资
            </label>
            <input v-model="salary_per_hour" id="salary_per_hour" class="form-control" type="number" required>
        </div>
        <div class="form-group">
            <label for="salary_fixed">
                固定薪资
            </label>
            <input v-model="salary_fixed" id="salary_fixed" class="form-control" type="number" required>
        </div>
        <div class="form-group">
            <label for="salary_rate">
                佣金率(%)
            </label>
            <input v-model="salary_rate" id="salary_rate" class="form-control" type="number" required>
        </div>
        <div class="form-group">
            <label for="hour_limit">
                小时限制
            </label>
            <input v-model="hour_limit" id="hour_limit" class="form-control" type="number" required>
        </div>
        <button class="btn btn-default form-control">添加雇员</button>
    </form>
</template>
<script>
    export default
    {
        data: function () {
            return {
                username: '孟政元',
                usertype: 'hour',
                tel: '12345678901',
                salary_per_hour: 100,
                salary_fixed: 10000,
                salary_rate: 10,
                hour_limit: 24,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/add_employee?username=${this.username}&usertype=${this.usertype}&tel=${this.tel}&salary_per_hour=${this.salary_per_hour}&salary_fixed=${this.salary_fixed}&salary_rate=${this.salary_rate}&hour_limit=${this.hour_limit}`;
                }
            },
        methods:
            {
                submit: function()
                {
                    console.log(this.request_url);
                    alert('添加雇员成功');
                }
            }
    }
</script>
<style scoped>

</style>