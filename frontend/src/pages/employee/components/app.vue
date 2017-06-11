<template>
    <div id="app">
        <navbar></navbar>
        <div id="body" class="container">
            <div class="row">
                <h3>人力资源管理系统</h3>
                <h4>Human Resources Management System</h4>
                <hr>
            </div>
            <div class="row">
                <div class="col-sm-3">
                    <ul class="list-group">
                        <li @click="change_panel('login')" class="list-group-item"
                            :class="{ active:  panel === 'login', disabled: online}">
                            登录
                        </li>
                        <li @click="change_panel('timecard')" class="list-group-item"
                            :class="{ active:  panel === 'timecard', disabled: !online}">
                            维护考勤时间卡
                        </li>
                        <li @click="change_panel('pay_method')" class="list-group-item"
                            :class="{ active:  panel === 'pay_method', disabled: !online}">
                            选择付款方式
                        </li>
                        <li @click="change_panel('add_order')" class="list-group-item"
                            :class="{ active:  panel === 'add_order', disabled: !online}">
                            创建订单
                        </li>
                        <li @click="change_panel('update_order')" class="list-group-item"
                            :class="{ active:  panel === 'update_order', disabled: !online}">
                            维护订单
                        </li>
                        <li @click="change_panel('delete_order')" class="list-group-item"
                            :class="{ active:  panel === 'delete_order', disabled: !online}">
                            删除订单
                        </li>
                    </ul>
                </div>
                <div class="col-sm-9">
                    <div id="panel" class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                雇员
                            </h3>
                        </div>
                        <div class="panel-body">
                            <login v-show=" panel === 'login' && !online "></login>
                            <timecard v-show=" panel === 'timecard' && online "></timecard>
                            <pay_method v-show=" panel === 'pay_method' && online "></pay_method>
                            <add_order v-show=" panel === 'add_order' && online "></add_order>
                            <update_order v-show=" panel === 'update_order' && online "></update_order>
                            <delete_order v-show=" panel === 'delete_order' && online "></delete_order>
                        </div>
                    </div>
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
    import update_order from './panels/update_order.vue';
    import add_order from './panels/add_order.vue';
    import delete_order from './panels/delete_order.vue';

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
                update_order,
                add_order,
                delete_order,
            },
        computed:
            {
                online: function()
                {
                    return this.$store.state.user.online;
                }
            },
        methods:
            {
                change_panel(panel_name)
                {
                    this.panel = panel_name;
                }
            },
        mounted: function()
        {
            const uid = localStorage.getItem('employee/uid');
            if(uid)
            {
                this.$store.commit('user/login', {uid: uid});
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
    .list-group-item
    {
        cursor: pointer;
    }
    #panel
    {
        /*border: 1px solid black;*/
    }
</style>