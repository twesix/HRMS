<template>
    <form @submit.prevent="submit" class="form">
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
        <div class="form-group">
            <label for="date">
                日期
            </label>
            <input v-model="date" id="date"
                   type="date" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">创建订单</button>
    </form>
</template>
<script>
    import {get, ms} from '../../../../vendor/utils.js';
    export default
    {
        data: function () {
            return {
                customer_point_of_contact: 'customer point of contact',
                customer_billing_address: 'customer billing address',
                products_purchased: 'products purchased',
                date: null,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/employee/add_order?uid=${this.$store.state.user.uid}&customer_point_of_contact=${this.customer_point_of_contact}&customer_billing_address=${this.customer_billing_address}&products_purchased=${this.products_purchased}&date=${this.date}`;
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
                        alert(`订单创建成功,订单id为：${result.message}`);
                    }
                    else
                    {
                        alert('订单创建失败');
                    }
                }
            }
    }
</script>
<style scoped>

</style>