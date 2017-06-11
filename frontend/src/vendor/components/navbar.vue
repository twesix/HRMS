<template>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">
                    <p>Vanging</p>
                </div>
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#navbar_collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="navbar_collapse">
                <ul class="nav navbar-nav navbar-right">

                    <li v-if="!online" @click.prevent="nop">
                        <a href="#">未登录</a>
                    </li>

                    <li v-if="online" @click.prevent="nop">
                        <a href="#">{{username}}</a>
                    </li>
                    <li v-if="online" @click.prevent="logout">
                        <a href="#"><span class="text-danger">退出</span></a>
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
                },
            methods:
                {
                    logout: function()
                    {
                        this.$store.commit('user/logout');
                    },
                    nop: function()
                    {
                        console.log('nop');
                    }
                }
        }
</script>
<style scoped>

</style>