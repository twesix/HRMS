import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

import admin from '../stores/admin.js'
import employee from '../stores/employee.js'
import backend from '../stores/backend.js'

const store = new Vuex.Store
(
    {
        modules:
            {
                admin,
                employee,
                backend
            },
        state:
            {
                usertype: null
            },
        mutations:
            {
                set_usertype: function(state, payload)
                {
                    state.usertype = payload.usertype;
                }
            }
    }
);

export default store;