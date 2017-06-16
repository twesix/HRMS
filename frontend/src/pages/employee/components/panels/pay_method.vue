<template>
    <form @submit.prevent="submit" class="form">
        <div class="form-group">
            <label for="pay_method">
                支付方式
            </label>
            <select v-model="pay_method" id="pay_method" class="form-control" required>
                <option value="receive">接收</option>
                <option value="mail">邮寄</option>
                <option value="deposit">直接存款</option>
            </select>
        </div>
        <div class="form-group">
            <label for="detail">
                具体信息
            </label>
            <input v-model="detail" id="detail" type="text" class="form-control">
        </div>
        <button class="btn btn-default form-control" type="submit">修改</button>
    </form>
</template>
<script>
    import {get} from '../../../../vendor/utils.js';
    export default
    {
        data: function () {
            return {
                pay_method: null,
                detail: null,
            };
        },
        computed:
            {
                request_url: function()
                {
                    return`${this.$store.state.backend.base_url}/employee/set_pay_method?id=${this.$store.state.user.uid}&method=${this.pay_method}&detail=${this.detail}`;
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
                        alert('修改成功');
                    }
                    else
                    {
                        alert('修改失败');
                    }
                }
            }
    }
</script>
<style scoped>

</style>