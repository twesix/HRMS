import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

import user from './modules/user.js';
import backend from '../../../vendor/stores/backend.js'

const store = new Vuex.Store
(
    {
        modules:
            {
                user,
                backend
            },
    }
);

export default store;