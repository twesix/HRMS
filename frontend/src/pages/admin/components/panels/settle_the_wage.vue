<template>
    <div>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>员工id</th>
                <th>员工姓名</th>
                <th>工资</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="wage in wages">
                <td>{{ wage.id }}</td>
                <td>{{ wage.name }}</td>
                <td>{{ wage.wage }}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
    export default
    {
        data: function () {
            return {
                wages:
                [
                    {
                        id: '001',
                        name: '孟政元',
                        wage: 10000
                    },
                    {
                        id: '002',
                        name: '赵俊法',
                        wage: 20000
                    },
                    {
                        id: '003',
                        name: '周心圆',
                        wage: 30000
                    },
                    {
                        id: '004',
                        name: '魏虹雨',
                        wage: 20000
                    }
                ]
            };
        },
        generated:
            {
                request_url: function()
                {
                    return `${this.$store.state.backend.base_url}`;
                }
            },
    }
</script>
<style scoped>

</style>