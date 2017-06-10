<template>
    <div>
        <form @submit.prevent="submit">
            <div class="form-group">
                <label for="employee_id">
                    雇员Id
                </label>
                <input id="employee_id" class="form-control" type="text" required>
            </div>
            <button class="btn btn-default form-control">查询</button>
        </form>
        <div id="employee_report"></div>
    </div>
</template>
<script>
    export default
        {
            data: function ()
            {
                return {};
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

                    }
                }
        }
</script>
<style scoped>

</style>