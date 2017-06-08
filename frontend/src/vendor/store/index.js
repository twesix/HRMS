import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

import user from './stores/user.js'
import backend from './stores/backend.js'

const store = new Vuex.Store
(
    {
        modules:
            {
                user,
                backend
            }
    }
);

export default store;