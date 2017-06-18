import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const base_url = DEVELOPMENT ? '//localhost:8080' : '//be.llc.vanging.com/hrms';

const backend =
    {
        state:
            {
                base_url: base_url
            }
    };

export default backend;