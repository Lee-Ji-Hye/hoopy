<template>
  <div>
    <img alt="Vue logo" src="../assets/logo.png">
    <h2>롤링페이퍼에 오신걸</h2>
    <h2>환영합니다!</h2>
    <button style="button">카카오계정으로 로그인</button>
    <h5><a href="/oauth2/authorization/google">GOOGLE</a></h5>
    <button style="button" @click="email">이메일</button>
    <h5>아직 회원이 아니신가요? 회원가입</h5>
    <h5>어려움이 있으신가요? 고객센터</h5>
  </div>
</template>

<script>

export default {
  name: 'Welcome',
  methods: {
    email() {
      this.$router.push('/loginPage');
    }
  }
}
</script>
