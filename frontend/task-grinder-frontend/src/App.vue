<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      <HelloWorld msg="Task Grinder Project" />
      <nav class="green">
        <RouterLink to="/">Profile</RouterLink>
        <RouterLink to="/questlog">Quest Log</RouterLink>
      </nav>
    </div>
  </header>
</template>

<style scoped>
@import './assets/main.css'
</style>
