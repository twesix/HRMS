const webpack = require('webpack');
const vars = require('../vars');

module.exports = new webpack.DllPlugin
(
    {
        path: vars.path.build.vendor.manifest,
        name: '[name]_[chunkhash]',
        context: vars.path.build.vendor.root
    }
);