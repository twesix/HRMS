const path=require('path');
const vars = require('./vars');

module.exports =
    {
        path: vars.path.build.root,
        filename:'[name]/entry.js',
        publicPath: vars.path.build.root,
        chunkFilename: '[name].chunk.js'
    };