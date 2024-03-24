<template>
    <nav class="nav">
      <a href="/" class="nav__link">Profile</a>
      <a href="/questlog" class="nav__link" >Quest Hub</a>
    </nav>
  <div class="about">
    <p>With this web app you can manage your tasks and give them a quest like character. You can assign a 
      difficulty to your tasks based on the motivation you need to complete them. Earn xp by completing tasks in time to level up. 
      As a motivation you can define rewards for leveling up. 
      A reward may be a nice Diner or watching a movie in cinema. This should help you building a routine doing daily tasks that feels rewarding.
    </p>
    <form v-on:submit.prevent="submitTask">
          <select v-model="questType" id="questTimeChoice">
            <option disabled value="">Select Quest Type</option>
            <option v-for="option in questOptions" :value="option">{{ option }}</option>
          </select>
      <input type="text" placeholder="task">
      <input type="date" placeholder="today">
      <button>Commit</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      questType: 'Quest Type',
      questOptions: ['once', 'weekly', 'monthly']
    }
  },
  methods: {
    submitTask() {
      alert("alright, let's do it!")
    }
  }
}
</script>