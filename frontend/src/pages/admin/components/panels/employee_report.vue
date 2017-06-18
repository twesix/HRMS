<template>
    <div>
        <form @submit.prevent="submit">
            <div class="form-group">
                <label for="employee_id">
                    雇员Id
                </label>
                <input v-model="id" id="employee_id" class="form-control" type="text" required>
            </div>
            <button class="btn btn-default form-control">查询</button>
        </form>
        <br>
        <hr>
        <br>
        <div id="employee_report" class="table-responsive">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>雇员id</td>
                    <td>{{ id }}</td>
                </tr>
                <tr>
                    <td>雇员姓名</td>
                    <td>{{ username }}</td>
                </tr>
                <tr>
                    <td>雇员类型</td>
                    <td>{{ usertype }}</td>
                </tr>
                <tr>
                    <td>电话号码</td>
                    <td>{{ tel }}</td>
                </tr>
                <tr>
                    <td>小时薪资</td>
                    <td>{{ salary_per_hour }}</td>
                </tr>
                <tr>
                    <td>固定薪资</td>
                    <td>{{ salary_fixed }}</td>
                </tr>
                <tr>
                    <td>佣金率(%)</td>
                    <td>{{ salary_rate }}</td>
                </tr>
                <tr>
                    <td>小时限制</td>
                    <td>{{ hour_limit }}</td>
                </tr>
                <tr>
                    <td>年初至今的收入</td>
                    <td>{{ income }}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
    const now = new Date();

    import {get, year_start} from '../../../../vendor/utils.js';
    export default
    {
        data: function ()
        {
            return {
                id: null,
                username: 0,
                usertype: 0,
                tel: 0,
                salary_per_hour: 0,
                salary_fixed: 0,
                salary_rate: 0,
                hour_limit: 0,
                income: 0,
            };
        },
        computed:
            {
                request_url_of_profile: function()
                {
                    return`${this.$store.state.backend.base_url}/admin/query_employee?id=${this.id}`;
                },
                request_url_of_salary: function()
                {
                    return`${this.$store.state.backend.base_url}/admin/worktime?id=${this.id}&start=${year_start.getTime()}&end=${now.getTime()}`;
                }
            },
        methods:
            {
                submit: async function()
                {
                    let result = await get(this.request_url_of_salary);
                    result = JSON.parse(result);
                    if(result.status === 'ok')
                    {
                        this.imcome = result.message;
                    }
                    else
                    {
                        alert('查询失败');
                    }
                    result = await get(this.request_url_of_profile);
                    result = JSON.parse(result);
                    if(result.status === 'ok')
                    {
                        this.__display_profile(result.message);
                    }
                    else
                    {
                        alert('查询失败');
                    }
                },
                __display_profile(profile)
                {
                    this.uid = profile.uid;
                    this.username = profile.username;
                    this.usertype = profile.usertype;
                    this.tel = profile.tel;
                    this.salary_per_hour = profile.salary_per_hour;
                    this.salary_fixed = profile.salary_fixed;
                    this.salary_rate = profile.salary_rate;
                    this.hour_limit = profile.hour_limit;
                }
            }
    }
</script>
<style scoped>

</style>