let webpack=require('webpack');
let path=require('path');

module.exports=
    {
        entry:'./src/index.js',
        output:
            {
                path:path.resolve(__dirname,'./dev'),
                filename:'index.js'
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