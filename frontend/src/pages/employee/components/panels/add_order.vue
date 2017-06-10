<template>
    <form @submit.prevent="submit" class="form">
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
                   type="password" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="products_purchased">
                products purchased
            </label>
            <input v-model="products_purchased" id="products_purchased"
                   type="password" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="datetime">
                date time
            </label>
            <input v-model="datetime" id="datetime"
                   type="datetime-local" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">创建订单</button>
    </form>
</template>
<script>
    export default
    {
        data: function () {
            return {
                customer_point_of_contact: null,
                customer_billing_address: null,
                products_purchased: null,
                datetime: null,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return `${this.$store.state.backend.base_url}/add_order`;
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