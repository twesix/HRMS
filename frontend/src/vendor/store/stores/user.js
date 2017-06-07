import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const user = new Vuex.Store
(
    {
        state:
            {
                online: true,
                uid: null
            },
        mutations:
            {
                login: function(state, payload)
                {
                    state.online = true;
                    state.uid = payload.uid;
                },
                logout: function(state)
                {
                    state.online = false;
                    state.uid = null
                }
            }
    }
);

export default user;