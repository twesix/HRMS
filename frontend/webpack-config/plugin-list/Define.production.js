const webpack = require('webpack');

module.exports = new webpack.DefinePlugin
(
    {
        PRODUCTION: true,
        DEVELOPMENT: false,
    }
);