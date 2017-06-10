<template>
    <form @submit.prevent="login" class="form">
        <div class="form-group">
            <label for="order_id">
                账户
            </label>
            <input v-model="order_id" id="order_id" type="text" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">删除订单</button>
    </form>
</template>
<script>
    export default
    {
        data: function () {
            return {
                order_id: null,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/delete_order?order_id=${this.order_id}`;
                }
            },
        methods:
            {
                login: function()
                {
                    console.log(this.request_url);
                }
            }
    }
</script>
<style scoped>

</style>