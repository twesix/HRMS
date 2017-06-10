<template>
    <form @submit.prevent="submit" class="form">
        <div class="form-group">
            <label for="order_id">
                订单id
            </label>
            <input v-model="order_id" id="order_id"
                   type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="customer_point_of_contact">
                customer point of contact
            </label>
            <input v-model="customer_point_of_contact" id="customer_point_of_contact"
                   type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="customer_billing_address">
                customer billing address
            </label>
            <input v-model="customer_billing_address" id="customer_billing_address"
                   type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="products_purchased">
                products purchased
            </label>
            <input v-model="products_purchased" id="products_purchased"
                   type="text" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">更新订单</button>
    </form>
</template>
<script>
    export default
    {
        data: function () {
            return {
                order_id: null,
                customer_point_of_contact: null,
                customer_billing_address: null,
                products_purchased: null,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/update_order?order_id=${this.order_id}&customer_point_of_contact=${this.customer_point_of_contact}&customer_billing_address=${this.customer_billing_address}&products_purchased=${this.products_purchased}`;
                }
            },
        methods:
            {
                submit: function()
                {
                    console.log(this.request_url);
                }
            }
    }
</script>
<style scoped>

</style>