const webpack = require('webpack');
const vars = require('../vars.js');

module.exports = new webpack.DllReferencePlugin
(
    {
        context: vars.path.build.vendor.root,
        manifest: vars.path.build.vendor.manifest
    }
);