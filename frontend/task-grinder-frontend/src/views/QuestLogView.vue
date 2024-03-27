<template>
  <div class="createTask">
    <form v-on:submit.prevent>
          <select v-model="taskType" id="questTimeChoice">
            <option disabled value="">Select Quest Type</option>
            <option v-for="option in questOptions" :value="option">{{ option }}</option>
          </select>
      <input v-model="taskName" type="text" placeholder="task">
      <select v-model="taskDate" v-if="taskType === 'weekly'" id="selectWeekly" >
        <option disabled value="">Select Day</option>
        <option v-for="day in weekdays" :value="day">{{ day }}</option>
      </select>
      <input v-model="taskDate" v-else type="date" placeholder="today">
      <button @click="submitTask" class="button">Commit</button>
    </form>
  </div>
  <div class="task-list">
    <div v-for="(task, index) in tasks" :key="index" class="task-item" >
      <div class="task-icon" >
          {{ task.type }}
      </div>
      <div class="task-info">
          <p> {{ task.name }} </p>
          <p> {{ task.date }} </p>
      </div>
      <div class="task-complete" v-bind="index">
        <button @click.stop="deleteTask(index)" class="button"> Done </button>
      </div>
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
    },
    deleteTask(index) {
      this.tasks.splice(index, 1)
    }
  }
}
</script>
<style scoped>
  .task-item {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin-bottom: 5px;
    background-color: rgba(0, 0, 0, 0.479);
    color: aliceblue;
    border-color: aliceblue;
  }
  .task-info {
    flex-grow: 1;
    align-self: right;
    align-content: right;
    margin-left: 20px;
    margin-right: 20px;
  }

  .task-icon {
    flex-grow: 1;
    align-self: auto;
  }
  .task-complete {
    flex-grow: 1;
  }

  .createTask {
    display: flex;
    background-color: rgba(0, 0, 0, 0.493);
    margin-bottom: 5px;
  }

  .button {
    background-color:  rgb(58, 124, 102);
    color: white;
    border: none;
    position: relative;
    min-height: 40px;
    min-width: 60px;
  }

</style>