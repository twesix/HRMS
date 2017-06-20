<template>
    <form @submit.prevent="submit" class="form">
        <div class="form-group">
            <label for="order_id">
                订单id
            </label>
            <input v-model="order_id" id="order_id" type="text" class="form-control" required>
        </div>
        <button class="btn btn-default form-control" type="submit">删除订单</button>
    </form>
</template>
<script>
    import {get} from '../../../../vendor/utils.js';
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
                    return`${this.$store.state.backend.base_url}/employee/delete_order?order_id=${this.order_id}&uid=${this.$store.state.user.uid}`;
                }
            },
        methods:
            {
                submit: async function()
                {
                    if(!confirm('确定要执行此操作?'))
                    {
                        return ;
                    }
                    console.log(this.request_url);
                    let result = await get(this.request_url);
                    console.log(result);
                    result = JSON.parse(result);
                    if(result.status === 'ok')
                    {
                        alert('删除成功');
                    }
                    else
                    {
                        alert('删除失败');
                    }
                }
            }
    }
</script>
<style scoped>

</style>