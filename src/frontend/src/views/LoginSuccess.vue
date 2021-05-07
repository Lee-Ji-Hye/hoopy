<template>
  <div>
    <div>
      <h3>{{msg}}</h3>
      <input type="hidden" id="token" v-model="token">
    </div>
    <div class="menu" ref="menu" @mousedown="mouseDown">≡</div>
    <button type="button" @click="auth">인증</button>
    <div class="dropdown" v-if="state.isOpened">
      <a href="/">메인화면</a><br>
      <a href="/loginPage">로그인</a>
    </div>
    <button type="button" @click="logout">로그아웃</button>
  </div>
</template>

<script>
import { ref, reactive } from 'vue'
import axios from 'axios'

export default {
  name: 'LoginSuccess',
  data () {
    return {
      msg: '',
      token: ''
    }
  },
  mounted () {
    fetch('/api/member/userInfo')
    .then((response) => response.text())
    .then((data) => {
      this.msg = data;
    }),
    fetch('/api/csrf-token')
    .then((response) => response.text())
    .then((data) => {
      this.token = data;
    })
  },
  methods: {
    auth(){
      axios.get('/api/member/hello')
    },
    logout() {
      axios.post('/logout', null, { 
        headers: { 
          'content-type': 'application/json',
          'X-CSRF-TOKEN': this.token
          //'Access-Control-Allow-Origin': '*'
        }
      }).then(response => {
        console.log('response: ', response)
      })
    }
  },
  setup() {
    const menu  = ref(null)
    const state = reactive({ isOpened : false })

    function mouseDown() {
      !state.isOpened ? open() : close()
    }
    
    function open() {
      state.isOpened = true
      //window.addEventListener('mousedown', outside)
    }
  
    function close() {
      state.isOpened = false
      //window.removeEventListener('mousedown', outside)
    }

    /* function outside(e) {
      if (e.target !== menu.value) close()
    } */

    return { menu, state, mouseDown }
  }
}
</script>

<style>
 .menu:hover{
   cursor: pointer;
 } 
</style>
