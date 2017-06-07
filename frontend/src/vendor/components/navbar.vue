<template>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">
                    <p>Vanging</p>
                </div>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">

                    <li v-if="!online">
                        <a href="#">登录</a>
                    </li>

                    <li class="dropdown" v-if="online">
                        <a href="#" data-toggle="dropdown"  class="dropdown-toggle">
                            ${username}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>退出</li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>
<script>
    export default
        {
            data: function () {
                return {

                };
            },
            computed:
                {
                    online: function()
                    {
                        return this.$store.state.user.online;
                    },
                    username: function()
                    {
                        return this.$store.state.user.uid;
                    }
                }
        }
</script>
<style scoped>

</style>