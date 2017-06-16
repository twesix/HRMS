<template>
    <div>
        <form @submit.prevent="query" class="form">
            <div class="form-group">
                <label for="order_id">
                    订单id
                </label>
                <input v-model="order_id" id="order_id"
                       type="text" class="form-control" required>
            </div>
            <button class="btn btn-default form-control">查询</button>
        </form>
        <hr>
        <form @submit.prevent="update" class="form">

            <div class="form-group">
                <label for="customer_point_of_contact">
                    客户联系人
                </label>
                <input v-model="customer_point_of_contact" id="customer_point_of_contact"
                       type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="customer_billing_address">
                    客户账单地址
                </label>
                <input v-model="customer_billing_address" id="customer_billing_address"
                       type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="products_purchased">
                    购买的产品
                </label>
                <input v-model="products_purchased" id="products_purchased"
                       type="text" class="form-control" required>
            </div>
            <button class="btn btn-default form-control" type="submit">更新订单</button>
        </form>
    </div>
</template>
<script>
    import {get} from '../../../../vendor/utils.js'
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
                request_url_of_update: function()
                {
                    return`${this.$store.state.backend.base_url}/employee/update_order?order_id=${this.order_id}&customer_point_of_contact=${this.customer_point_of_contact}&customer_billing_address=${this.customer_billing_address}&products_purchased=${this.products_purchased}`;
                },
                request_url_of_query: function()
                {
                    return`${this.$store.state.backend.base_url}/employee/query_order?order_id=${this.order_id}`;
                }
            },
        methods:
            {
                query: async function()
                {
                    let result = await get(this.request_url_of_query);
                    result = JSON.parse(result);
                    if(result.status === 'ok')
                    {
                        this.__display_order(result.message);
                    }
                    else
                    {
                        alert('订单不存在');
                    }
                },
                update: async function()
                {
                    let result = await get(this.request_url_of_update);
                    result = JSON.parse(result);
                    if(result.status === 'ok')
                    {
                        alert('更新成功');
                    }
                    else
                    {
                        alert('更新失败');
                    }
                },
                __display_order: function(order)
                {
                    this.customer_point_of_contact = order.customer_point_of_contact;
                    this.customer_billing_address = order.customer_billing_address;
                    this.products_purchased = order.products_purchased;
                }
            }
    }
</script>
<style scoped>

</style>