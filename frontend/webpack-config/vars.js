const path = require('path');

module.exports =
    {
        path:
            {
                build:
                    {
                        root: path.resolve('./build'),
                        vendor:
                            {
                                root: path.resolve('./build/vendor'),
                                manifest: path.resolve('./build/vendor/manifest.json')
                            },
                    },
                src:
                    {
                        root: path.resolve('./src'),
                        pages: path.resolve('./src/pages'),
                        vendor: path.resolve('./src/vendor')
                    }
            }
    };