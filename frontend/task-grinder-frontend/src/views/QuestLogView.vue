<template>
  <div class="createTask">
    <form v-on:submit.prevent>
          <select v-model="taskType" id="questTimeChoice">
            <option disabled value="">Select Quest Type</option>
            <option v-for="option in questOptions" :value="option">{{ option }}</option>
          </select>
      <input v-model="taskName" type="text" placeholder="task">
      <select v-model="taskDate" v-if="questType === 'weekly'" id="selectWeekly" >
        <option disabled value="">Select Day</option>
        <option v-for="day in weekdays" :value="day">{{ day }}</option>
      </select>
      <input v-model="taskDate" v-else type="date" placeholder="today">
      <button @click="submitTask">Commit</button>
    </form>
  </div>
  <div class="listTask">
    <div >

    </div>
  </div>
</template>
<script>


export default {
  data() {
    return {
      taskName: '',
      taskType: '',
      taskDate: '',
      tasks: [],
      questType: '',
      questOptions: ['once', 'weekly', 'monthly'],
      selectedWeekday: '',
      weekdays: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
    }
  },
  methods: {
    submitTask() {
      alert("alright, let's do it!"),
      this.tasks.push({
        name: this.taskName,
        type: this.taskType,
        date: this.taskDate
      })
      this.taskName = '',
      this.taskType = '',
      this.taskDate = ''
      
    }
  }
}
</script>