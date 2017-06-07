import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const user = new Vuex.Store
(
    {
        state:
            {
                online: false,
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

const uid = localStorage.getItem('uid');
if(uid)
{
    user.commit('login', {uid: uid});
}

export default user;