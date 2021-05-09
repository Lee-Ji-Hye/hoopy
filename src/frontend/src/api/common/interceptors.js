//import store from '@/store/index';

export function settingInterceptor(instance) {
	instance.interceptors.request.use(
		function (config) {
			//interceptors user token 설정
			//config.headers.Authorization = store.state.token;
			return config;
		},
		function (error) {
			console.log('interceptor request error: ', error);
			return Promise.reject(error);
		},
	);

	// Add a response interceptor
	instance.interceptors.response.use(
		function (response) {
			console.log('interceptor response: ', response);
			return response;
		},
		function (error) {
			console.log('interceptor response error: ', error);
			return Promise.reject(error);
		},
	);

	return instance;
}
