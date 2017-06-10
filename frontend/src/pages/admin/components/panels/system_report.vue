<template>
    <div>
        <h2>system-report</h2>
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
        }
</script>
<style scoped>

</style>