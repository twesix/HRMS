<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="profile_id">
                Id
            </label>
            <input id="profile_id" class="form-control" type="text">
        </div>
        <button class="btn btn-default">Submit</button>
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