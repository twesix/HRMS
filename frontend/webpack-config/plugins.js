const path=require('path');

module.exports =
    {
        CommonsChunk: require('./plugin-list/CommonsChunk'),
        Define: require('./plugin-list/Define'),
        Dll: require('./plugin-list/Dll'),
        DllReference: require('./plugin-list/DllReference'),
        ExtractText: require('./plugin-list/ExtractText'),
        HtmlWebpack: require('./plugin-list/HtmlWebpack'),
        Provide: require('./plugin-list/Provide'),
    };
