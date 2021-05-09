import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		//여러 컴포넌트의 데이터
		username: '',
		loginState: '',
		token: '',
	},
	getters: {
		//computed와 비슷한 기능
		isLogin(state) {
			return state.loginState === ''; // true, false
		},
	},
	mutations: {
		//state 변경
		setLoginState(state, loginState) {
			state.loginState = loginState;
		},
		setToken(state, token) {
			state.token = token;
		},
	},
	actions: {},
	modules: {},
});
