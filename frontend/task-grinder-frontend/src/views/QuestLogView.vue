<template>
    <nav class="nav">
      <a href="/" class="nav__link">Profile</a>
      <a href="/questlog" class="nav__link" >Quest Hub</a>
    </nav>
  <div class="about">
    <form v-on:submit.prevent="submitTask">
          <select v-model="questType" id="questTimeChoice">
            <option disabled value="">Select Quest Type</option>
            <option v-for="option in questOptions" :value="option">{{ option }}</option>
          </select>
      <input type="text" placeholder="task">
      <select v-if="questType === 'weekly'" id="selectWeekly" >
        <option disabled value="">Select Day</option>
        <option v-for="day in weekdays" :value="day">{{ day }}</option>
      </select>
      <input  v-else type="date" placeholder="today">
      <button>Commit</button>
    </form>
  </div>
</template>
<script>


export default {
  data() {
    return {
      questType: '',
      questOptions: ['once', 'weekly', 'monthly'],
      selectedWeekday: '',
      weekdays: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
    }
  },
  methods: {
    submitTask() {
      alert("alright, let's do it!")
    }
  }
}
</script>