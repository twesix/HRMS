<template>
    <form @submit.prevent="submit" class="form">
        <div class="form-group">
            <label for="project_id">
                项目id
            </label>
            <input v-model="project_id" id="project_id" type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="start_time">
                开始时间
            </label>
            <input v-model="start_time" id="start_time" type="number" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="end_time">
                结束时间
            </label>
            <input v-model="end_time" id="end_time" type="number" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">提交</button>
    </form>
</template>
<script>
    import {get} from '../../../../vendor/utils.js';
    export default
    {
        data: function () {
            return {
                project_id: null,
                start_time: null,
                end_time: null
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/employee/add_timecard?pid=${this.project_id}&uid=${this.$store.state.user.uid}&start=${this.start_time}&end=${this.end_time}`;
                }
            },
        methods:
            {
                submit: async function()
                {
                    let result = await get(this.request_url);
                    result = JSON.parse(result);
                    if(result.status === 'ok')
                    {
                        alert('打卡成功');
                    }
                    else
                    {
                        alert('打卡失败');
                    }
                }
            }
    }
</script>
<style scoped>

</style>