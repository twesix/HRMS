<template>
    <div>
        <h2>settle_the_wage!</h2>
    </div>
</template>
<script>
    export default
    {
        data: function () {
            return {};
        },
        generated:
            {
                request_url: function()
                {
                    return `${this.$store.state.backend.base_url}`;
                }
            },
    }
</script>
<style scoped>

</style>