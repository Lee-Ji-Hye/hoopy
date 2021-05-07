<template>
  <div>
    <div>
      <h3>{{msg}}</h3>
    </div>
    <div class="menu" ref="menu" @mousedown="mouseDown">≡</div>
    <button type="button" @click="auth">인증</button>
    <div class="dropdown" v-if="state.isOpened">
      <a href="/">메인화면</a><br>
      <a href="/loginPage">로그인</a>
    </div>
  </div>
</template>

<script>
import { ref, reactive } from 'vue'
import axios from 'axios'

export default {
  name: 'LoginSuccess',
  data () {
    return {
      msg: ''
    }
  },
  mounted () {
    fetch('/api/member/userInfo')
    .then((response) => response.text())
    .then((data) => {
      this.msg = data;
    })
  },
  methods: {
    auth(){
      axios.get('/api/member/hello')
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
