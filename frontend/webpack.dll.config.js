const webpack = require('webpack');
const vars = require('./webpack-config/vars');
const plugins = require('./webpack-config/plugins');

const vendors =
    [
        'jquery',
        'bootstrap.css',
        'bootstrap.js',
        'vue',
        'vuex',
        'vue-router'
    ];

module.exports =
    {
        entry:
            {
                vendor: vendors
            },
        output:
            {
                path: vars.path.build.vendor.root,
                filename:'dll.js',
                library: '[name]_[chunkhash]'
            },
        module: require('./webpack-config/module'),
        resolve: require('./webpack-config/resolve'),
        plugins:
            [
                plugins.Provide,
                plugins.Dll,
            ]
    };