<template>
    <div id="app">
        <navbar></navbar>
        <div id="body" class="container">
            <div class="row">
                <h2>Human Resource Management System</h2>
                <hr>
            </div>
            <div class="row">
                <div class="col-sm-3">
                    <ul class="list-group">
                        <li @click="change_panel('login')" class="list-group-item"
                            :class="{ active:  panel === 'login'}">
                            登录
                        </li>
                        <li @click="change_panel('timecard')" class="list-group-item"
                            :class="{ active:  panel === 'timecard'}">
                            维护考勤时间卡
                        </li>
                        <li @click="change_panel('pay_method')" class="list-group-item"
                            :class="{ active:  panel === 'pay_method'}">
                            选择付款方式
                        </li>
                        <li @click="change_panel('maintain_order')" class="list-group-item"
                            :class="{ active:  panel === 'maintain_order'}">
                            维护采购订单
                        </li>
                    </ul>
                </div>
                <div class="col-sm-9" id="panel">
                    <login v-show=" panel === 'login' "></login>
                    <timecard v-show=" panel === 'timecard' "></timecard>
                    <pay_method v-show=" panel === 'pay_method' "></pay_method>
                    <maintain_order v-show=" panel === 'maintain_order' "></maintain_order>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import navbar from '../../../vendor/components/navbar.vue';
    import login from './panels/login.vue';
    import timecard from './panels/timecard.vue';
    import pay_method from './panels/pay_method.vue';
    import maintain_order from './panels/maintain_order.vue';
    export default
    {
        data: function ()
        {
            return {
                panel: 'login'
            };
        },
        components:
            {
                navbar,
                login,
                timecard,
                pay_method,
                maintain_order,
            },
        methods:
            {
                change_panel(panel_name)
                {
                    this.panel = panel_name;
                }
            }
    }
</script>
<style scoped>
    #app
    {
        width: 100%;
        height: 100%;
    }
</style>
<style>
    html,
    body
    {
        width: 100%;
        height: 100%;
        padding: 0;
        margin: 0;
    }

    #panel
    {
        border: 1px solid black;
    }
</style>