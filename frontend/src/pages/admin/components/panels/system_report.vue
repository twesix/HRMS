<template>
    <div>
        <form @submit.prevent="submit">
            <div class="form-group">
                <label for="employee_id">
                    雇员Id
                </label>
                <input v-model="id" id="employee_id" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="report_type">
                    报告类型
                </label>
                <select v-model="report_type" id="report_type" class="form-control" required>
                    <option value="total">总工作时间</option>
                    <option value="year_to_date">年初至今</option>
                </select>
            </div>
            <div class="form-group">
                <label for="start_time">
                    开始时间
                </label>
                <input v-model="start_time" id="start_time" class="form-control" type="date" required>
            </div>
            <div class="form-group">
                <label for="end_time">
                    结束时间
                </label>
                <input v-model="end_time" id="end_time" class="form-control" type="date" required>
            </div>
            <button class="btn btn-default form-control">查询</button>
        </form>
        <hr>
        <table class="table table-bordered">
            <tbody>
            <tr>
                <td>姓名：</td>
                <td>{{ username }}</td>
            </tr>
            <tr>
                <td>id:</td>
                <td>{{ id }}</td>
            </tr>
            <tr>
                <td>工作时间：</td>
                <td>{{ work_time }}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
    const reports =
        {
            '001':
                {
                    username: '孟政元',
                    work_time: 100
                },
            '002':
                {
                    username: '赵俊法',
                    work_time: 200
                }
        };
    export default
        {
            data: function ()
            {
                return {
                    id: null,
                    report_type: 'total',
                    start_time: null,
                    end_time: null,
                    username: null,
                    work_time: 0,
                };
            },
            computed:
                {
                    request_url: function()
                    {
                        return`${this.$store.state.backend.base_url}/system_report?id=${this.id}&report_type=${this.report_type}&start_time=${this.start_time}&end_time=${this.end_time}`;
                    }
                },
            methods:
                {
                    submit: function()
                    {
                        console.log(this.request_url);
                        const report = reports[this.id];
                        if(report)
                        {
                            this.__display_report(report);
                        }
                        else
                        {
                            alert('用户id不存在');
                        }
                    },
                    __display_report: function(report)
                    {
                        this.username = report.username;
                        this.word_time = report.work_time;
                    }
                }
        }
</script>
<style scoped>

</style>