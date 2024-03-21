<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <img alt="Hero in Kitchen" class="logo" src="@/assets/dishes.jpg" />
    <div class="wrapper">
      <HelloWorld msg="Task Grinder Project" />
      <nav>
        <RouterLink to="/">Profile</RouterLink>
        <RouterLink to="/questlog">Quest Log</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
</style>

method: