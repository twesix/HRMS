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
                    localStorage.setItem('admin/uid', payload.uid);
                    state.uid = payload.uid;
                },
                logout: function(state)
                {
                    state.online = false;
                    state.uid = null;
                    localStorage.removeItem('admin/uid');
                }
            }
    };

export default user;