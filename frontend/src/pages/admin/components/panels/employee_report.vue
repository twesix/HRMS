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
                    <td>{{ uid }}</td>
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
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
    const reports =
        {
            '001':
                {
                    uid: '001',
                    username: '孟政元',
                    usertype: 'hour',
                    tel: '12345678901',
                    salary_per_hour: 100,
                    salary_fixed: 10000,
                    salary_rate: 10,
                    hour_limit: 24,
                },
            '002':
                {
                    uid: '002',
                    username: '赵俊法',
                    usertype: 'salary',
                    tel: '12345678901',
                    salary_per_hour: 200,
                    salary_fixed: 15000,
                    salary_rate: 20,
                    hour_limit: 14,
                }
        };
    export default
    {
        data: function ()
        {
            return {
                id: null,
                uid: null,
                username: 0,
                usertype: 0,
                tel: 0,
                salary_per_hour: 0,
                salary_fixed: 0,
                salary_rate: 0,
                hour_limit: 0,
            };
        },
        generated:
            {
                request_url: function()
                {
                    return `${this.$store.state.backend.base_url}`;
                }
            },
        methods:
            {
                submit: function()
                {
                    const report = reports[this.id];
                    if(report)
                    {
                        this.__display_report(report);
                    }
                    else
                    {
                        alert('这个员工id不存在');
                    }
                },
                __display_report(profile)
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