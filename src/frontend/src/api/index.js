import axios from 'axios';
//import { settingInterceptor } from './common/interceptors';

// 회원가입
async function signup(userData) {
	const response = await axios.get(process.env.VUE_APP_API_URL + '/api/csrf-token');

	const axiosInstance = axios.create({
		headers: {
			'content-type': 'application/json',
        	'X-CSRF-TOKEN': response.data,
		},
		params: {
			username: userData.username,
			password: userData.password
		}
	});

	return axiosInstance.post(process.env.VUE_APP_API_URL + '/api/login');
}

export { signup };
