const webpack = require('webpack');

module.exports = new webpack.DefinePlugin
(
    {
        PRODUCTION: process.env.NODE_ENV === 'production',
        DEVELOPMENT: process.env.NODE_ENV === 'development',
    }
);