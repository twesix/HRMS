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
                        <li @click="change_panel('system_report')" class="list-group-item"
                            :class="{ active:  panel === 'system_report'}">
                            系统报告
                        </li>
                        <li @click="change_panel('employee_report')" class="list-group-item"
                            :class="{ active:  panel === 'employee_report'}">
                            用户报告
                        </li>
                        <li @click="change_panel('maintain_employee_profile')" class="list-group-item"
                            :class="{ active:  panel === 'maintain_employee_profile'}">
                            维护雇员信息
                        </li>
                        <li @click="change_panel('settle_the_wage')" class="list-group-item"
                            :class="{ active:  panel === 'settle_the_wage'}">
                            运行工资结算系统
                        </li>
                    </ul>
                </div>
                <div class="col-sm-9" id="panel">
                    <login v-show=" panel === 'login' "></login>
                    <system_report v-show=" panel === 'system_report' "></system_report>
                    <employee_report v-show=" panel === 'employee_report' "></employee_report>
                    <maintain_employee_profile v-show=" panel === 'maintain_employee_profile' "></maintain_employee_profile>
                    <settle_the_wage v-show=" panel === 'settle_the_wage' "></settle_the_wage>
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
    import maintain_employee_profile from './panels/maintain_employee_profile.vue';
    import settle_the_wage from './panels/settle_the_wage.vue';
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
                    maintain_employee_profile,
                    settle_the_wage
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