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
                        <li  @click="change_panel('system_report')" class="list-group-item"
                            :class="{ active:  panel === 'system_report', disabled: !online} ">
                            生成管理报告
                        </li>
                        <li @click="change_panel('employee_report')" class="list-group-item"
                            :class="{ active:  panel === 'employee_report', disabled: !online}">
                            生成雇员报告
                        </li>
                        <li @click="change_panel('add_employee')" class="list-group-item"
                            :class="{ active:  panel === 'add_employee', disabled: !online}">
                            添加雇员
                        </li>
                        <li @click="change_panel('update_or_delete_employee')" class="list-group-item"
                            :class="{ active:  panel === 'update_or_delete_employee', disabled: !online}">
                            修改或删除雇员
                        </li>
                        <li @click="change_panel('settle_the_wage')" class="list-group-item"
                            :class="{ active:  panel === 'settle_the_wage', disabled: !online}">
                            工资结算
                        </li>
                    </ul>
                </div>
                <div class="col-sm-9">
                    <div id="panel" class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                管理员
                            </h3>
                        </div>
                        <div class="panel-body">
                            <login v-show=" panel === 'login' && !online "></login>
                            <system_report v-show=" panel === 'system_report' && online "></system_report>
                            <employee_report v-show=" panel === 'employee_report' && online "></employee_report>
                            <update_or_delete_employee v-show=" panel === 'update_or_delete_employee' && online ">
                            </update_or_delete_employee>
                            <settle_the_wage v-show=" panel === 'settle_the_wage' && online "></settle_the_wage>
                            <add_employee v-show=" panel === 'add_employee' && online "></add_employee>
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
    import system_report from './panels/system_report.vue';
    import employee_report from './panels/employee_report.vue';
    import update_or_delete_employee from './panels/update_or_delete_employee.vue';
    import settle_the_wage from './panels/settle_the_wage.vue';
    import add_employee from './panels/add_employee.vue';
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
                    system_report,
                    employee_report,
                    update_or_delete_employee,
                    settle_the_wage,
                    add_employee,
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
                const uid = localStorage.getItem('admin/uid');
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