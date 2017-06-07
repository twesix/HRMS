module.exports =
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
        },
        {
            test: /\.css$/,
            loader: 'style-loader!css-loader',
            exclude: '/node_modules/'
        },
        {
            test: /.(png|jpg|jpeg|gif)$/,
            loader: 'url-loader?limit=8192&name=./static/img/[hash].[ext]'
        },
        {
            test: /.(eot|svg|ttf|woff|woff2)$/,
            loader: 'url-loader?limit=8192&name=./static/font/[hash].[ext]'
        },
    ];