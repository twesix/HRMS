import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const backend =
    {
        state:
            {
                base_url: '//localhost:8080'
            },
        mutations:
            {
                online: function()
                {

                },
                offline: function()
                {

                }
            }
    };

export default backend;