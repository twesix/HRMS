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
            <input v-model="start_time" id="start_time" type="password" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="end_time">
                结束时间
            </label>
            <input v-model="end_time" id="end_time" type="password" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">提交</button>
    </form>
</template>
<script>
    export default
    {
        data: function () {
            return {
                project_id: null,
                start_time: null,
                end_time: null
            };
        },
        components: {},
        methods:
            {
                submit: function()
                {

                }
            }
    }
</script>
<style scoped>

</style>