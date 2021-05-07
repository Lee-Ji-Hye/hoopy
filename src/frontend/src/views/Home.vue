<template>
  <div>
    <div>
      <h2>나의 롤링페이퍼</h2>
      <h5>남이 생각하는 나는</h5>
      <h5>어떤 모습일까?</h5>
    </div>
    <div>
      <button type="button" id="start" @click="start">시작하기</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  methods: {
    start() {
      this.$router.push('/welcome')
    }
  }
}
</script>
