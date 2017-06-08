const plugins = require('./webpack-config/plugins');
const vars = require('./webpack-config/vars');

module.exports=
    {
        entry: { init: './src/init.js' },
        output: { path: vars.path.build.root, filename: 'init.js'},
        module: require('./webpack-config/module'),
        resolve: require('./webpack-config/resolve'),
        plugins:
        [
            // plugins.CommonsChunk,
            // plugins.Provide,
            // plugins.DllReference,
            // plugins.Define
        ]
            .concat(plugins.HtmlWebpack)
    };