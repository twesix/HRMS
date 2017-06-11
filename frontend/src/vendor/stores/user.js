const user =
    {
        namespaced: true,
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
                    localStorage.setItem(payload.usertype, payload.uid);
                    state.uid = payload.uid;
                },
                logout: function(state, payload)
                {
                    state.online = false;
                    state.uid = null;
                    localStorage.removeItem(payload.usertype)
                }
            }
    };

export default user;