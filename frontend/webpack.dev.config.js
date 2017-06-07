const plugins = require('./webpack-config/plugins');

module.exports=
    {
        entry: require('./webpack-config/entry'),
        output: require('./webpack-config/output'),
        module: require('./webpack-config/module'),
        resolve: require('./webpack-config/resolve'),
        plugins:
        [
            plugins.CommonsChunk,
            plugins.Provide,
            plugins.DllReference,
            plugins.Define
        ]
            .concat(plugins.HtmlWebpack)
    };