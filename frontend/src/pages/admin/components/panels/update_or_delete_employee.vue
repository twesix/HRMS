<template>
    <div>
        <form class="form" @submit.prevent="query">
            <div class="form-group">
                <label for="profile_id">
                    雇员Id
                </label>
                <input v-model="id" id="profile_id" class="form-control" type="text" required>
            </div>
            <button class="btn btn-default form-control">查询</button>
        </form>
        <br>
        <br>
        <hr>
        <br>
        <br>
        <form @submit.prevent="update" class="form">
            <div class="form-group">
                <label for="profile_username">
                    雇员姓名
                </label>
                <input v-model="username" id="profile_username" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="profile_usertype">
                    雇员类型
                </label>
                <select v-model="usertype" id="profile_usertype" class="form-control" required>
                    <option value="hour">小时</option>
                    <option value="salary">受薪</option>
                    <option value="commission">委托</option>
                </select>
            </div>
            <div class="form-group">
                <label for="profile_tel">
                    电话号码
                </label>
                <input v-model="tel" id="profile_tel" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="profile_salary_per_hour">
                    小时薪资
                </label>
                <input v-model="salary_per_hour" id="profile_salary_per_hour" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="profile_salary_fixed">
                    固定薪资
                </label>
                <input v-model="salary_fixed" id="profile_salary_fixed" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="profile_salary_rate">
                    佣金率
                </label>
                <input v-model="salary_rate" id="profile_salary_rate" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="profile_hour_limit">
                    小时限制
                </label>
                <input v-model="hour_limit" id="profile_hour_limit" class="form-control" type="number" required>
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
    const employees =
        {
            '001':
                {
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
        data: function () {
            return {
                id: null,
                username: 0,
                usertype: 0,
                tel: 0,
                salary_per_hour: 0,
                salary_fixed: 0,
                salary_rate: 0,
                hour_limit: 0,
            };
        },
        computed:
            {
                request_url_of_update: function()
                {
                    return`${this.$store.state.backend.base_url}/update_employee?id=${this.id}&username=${this.username}&usertype=${this.usertype}&tel=${this.tel}&salary_per_hour=${this.salary_per_hour}&salary_fixed=${this.salary_fixed}&salary_rate=${this.salary_rate}&hour_limit=${this.hour_limit}`;
                },
                request_url_of_query: function()
                {
                    return`${this.$store.state.backend.base_url}/query_employee?id=${this.id}`;
                },
                request_url_of_delete: function()
                {
                    return`${this.$store.state.backend.base_url}/delete_employee?id=${this.id}`;
                }
            },
        methods:
            {
                update: function()
                {
                    console.log(this.request_url_of_update);
                    alert('更新成功');
                },
                query: function()
                {
                    const profile = employees[this.id];
                    if(profile)
                    {
                        this.__display_employee(profile);
                    }
                    else
                    {
                        alert('这个id对应的雇员不存在');
                    }
                    console.log(this.request_url_of_query);
                },
                remove: function()
                {
                    console.log(this.request_url_of_delete);
                    alert('删除成功');
                },
                __display_employee(profile)
                {
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