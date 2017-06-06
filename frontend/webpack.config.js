let webpack=require('webpack');
let path=require('path');

module.exports=
    {
        entry:
            {
                admin: './src/admin/index.js',
                employee: './src/admin/index.js'
            },
        output:
            {
                path:path.resolve(__dirname,'./dev'),
                filename:'[name].js'
            },
        module:
            {
                loaders:
                    [
                        {
                            test: /\.vue$/,
                            loader: 'vue-loader'
                        },
                        {
                            test:/\.js$/,
                            loader:'babel-loader',
                            exclude:'/node_modules/',
                            query:
                                {
                                    presets: ['latest', 'stage-0']
                                }

                        }
                    ]
            }
    };