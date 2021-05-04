<template>
  <div>
    <input type="hidden" id="token" v-model="token">
    <div>
      <label>아이디</label>
      <input type="text" id="userid" v-model="userid">
    </div>
    <div>
      <label>비밀번호</label>
      <input type="text" id="password" v-model="password">
    </div>
    <div>
      <button type="button" @click="login">로그인</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HelloWorld',
  data () {
    return {
      token: ''
    }
  },
  mounted () {
    fetch('/api/csrf-token')
    .then((response) => response.text())
    .then((data) => {
      this.token = data;
    })
  },
  methods: {
    login() {
      axios.post('/api/login', null, { 
        headers: { 
          'content-type': 'application/json',
          'X-CSRF-TOKEN': this.token
          //'Access-Control-Allow-Origin': '*'
        },
        params: {
          username: this.userid,
          password: this.password
        }
      }).then(response => {
        console.log('response: ', response)
        this.$router.push('/about')
      }).catch(error => {
        console.log('error: ', error.response)
      })
    }
  }
}

</script>