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
            <!--<div class="form-group">-->
                <!--<label for="start_time">-->
                    <!--开始时间-->
                <!--</label>-->
                <!--<input v-model="start_time" id="start_time" class="form-control" type="date" required>-->
            <!--</div>-->
            <!--<div class="form-group">-->
                <!--<label for="end_time">-->
                    <!--结束时间-->
                <!--</label>-->
                <!--<input v-model="end_time" id="end_time" class="form-control" type="date" required>-->
            <!--</div>-->
            <button class="btn btn-default form-control">查询</button>
        </form>
        <hr>
        <table class="table table-bordered">
            <tbody>
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
    const now = new Date();

    import {get, year_start} from '../../../../vendor/utils.js';
    export default
        {
            data: function ()
            {
                return {
                    id: null,
                    report_type: 'total',
                    work_time: 0,
                };
            },
            computed:
                {
                    request_url_of_total: function()
                    {
                        return`${this.$store.state.backend.base_url}/admin/worktime?id=${this.id}&start=${0}&end=${now.getTime()}`;
                    },
                    request_url_of_year_to_date: function()
                    {
                        return`${this.$store.state.backend.base_url}/admin/worktime?id=${this.id}&start=${year_start.getTime()}&end=${now.getTime()}`;
                    }
                },
            methods:
                {
                    submit: async function()
                    {
                        let result;
                        if(this.report_type === 'total')
                        {
                            result = await get(this.request_url_of_total);
                        }
                        if(this.report_type === 'year_to_date')
                        {
                            result = await get(this.request_url_of_year_to_date);
                        }
                        result = JSON.parse(result);
                        if(result.status === 'ok')
                        {
                            this.work_time = result.message;
                        }
                        else
                        {
                            alert('查询出错');
                        }
                    }
                }
        }
</script>
<style scoped>

</style>