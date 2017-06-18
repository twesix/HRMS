const webpack = require('webpack');

module.exports = new webpack.DefinePlugin
(
    {
        PRODUCTION: false,
        DEVELOPMENT: true,
    }
);