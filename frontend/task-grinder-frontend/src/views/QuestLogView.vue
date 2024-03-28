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
          {{ task.date }}
      </div>
      <div class="task-info">
          <p> {{ task.name }} </p>
      </div>
      <div class="task-complete" v-bind="index">
        <button @click.stop="deleteTask(index)" class="button"> Done </button>
      </div>
    </div>
  </div>
  <div v-if="showMessageBox" class="message-box">
      <span class="message-text">{{ message }}</span>
      <div class="progress-bar"></div>
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
      showMessageBox: false,
      message: ''
    }
  },
  methods: {
    submitTask() {
      this.showMessage(),
      this.tasks.push({
        name: this.taskName,
        type: this.taskType,
        date: this.taskDate
      })
      this.taskName = '',
      this.taskType = '',
      this.taskDate = ''
    },
    showMessage() {
      // Set your message here
      this.message = 'alright, lets do it!';
      this.showMessageBox = true;
      setTimeout(() => {
        this.showMessageBox = false;
      }, 3000);// Hide the message box after 2 seconds
     }, 
    deleteTask(index) {
      this.tasks.splice(index, 1)
    }
  }
}
</script>
<style scoped>
  /* Form styling */
  form {
    background-color: rgba(0, 0, 0, 0.5); /* Translucent black background */
    padding: 1rem; /* Add padding for spacing */
    border-radius: 10px; /* Add border radius for rounded corners */
  }

  /* Input and select styling */
  input[type="text"],
  input[type="date"],
  select {
    background-color: transparent; /* Set background color to transparent */
    color: white; /* Set text color to white */
    border: 1px solid white; /* Add white border */
    border-radius: 5px; /* Add border radius for rounded corners */
    padding: 0.5rem; /* Add padding for spacing */
    margin-bottom: 1rem; /* Add bottom margin for spacing */
    width: 100%; /* Set width to 100% */
    box-sizing: border-box; /* Include padding and border in width calculation */
  }

  /* Select dropdown styling */
  select {
    -webkit-appearance: none; /* Remove default appearance */
    -moz-appearance: none; /* Remove default appearance */
    appearance: none; /* Remove default appearance */
    background: transparent url('data:image/svg+xml;utf8,<svg fill="white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z" /></svg>') no-repeat right 0.5rem center; /* Set custom dropdown arrow */
    background-size: 1.2rem; /* Set background size for the arrow */
  }

  /* Option styling */
  select option {
    background-color: rgba(0, 0, 0, 0.5); /* Translucent black background for options */
    color: white; /* Text color for options */
  }

  /* Button styling */
  .button {
    background-color: rgb(58, 124, 102); /* Green button background color */
    color: white; /* Button text color */
    border: none; /* Remove button border */
    padding: 0.5rem 1rem; /* Add padding for spacing */
    border-radius: 5px; /* Add border radius for rounded corners */
    cursor: pointer; /* Change cursor to pointer on hover */
  }

  /* Button hover effect */
  .button:hover {
    background-color: rgb(44, 96, 79); /* Darker green on hover */
  }

    /* Task list styling */
    .task-list {
    margin-top: 1rem; /* Add top margin for spacing */
  }

  .task-item {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin-bottom: 5px;
    background-color: rgba(0, 0, 0, 0.479); /* Translucent black background for task items */
    color: white; /* Text color */
    border: 1px solid white; /* White border */
    border-radius: 5px; /* Rounded corners */
    padding: 0.5rem; /* Add padding for spacing */
  }

  .task-info {
    flex-grow: 1; /* Take remaining space */
    margin: 0 1rem; /* Add margin for spacing */
  }

  .task-icon {
    flex-shrink: 0; /* Prevent icon from shrinking */
    margin-right: 1rem; /* Add margin for spacing */
  }

  .task-complete {
    flex-shrink: 0; /* Prevent button from shrinking */
  }

  /* Button styling */
  .button {
    background-color: rgb(58, 124, 102); /* Green button background color */
    color: white; /* Button text color */
    border: none; /* Remove button border */
    padding: 0.5rem 1rem; /* Add padding for spacing */
    border-radius: 5px; /* Add border radius for rounded corners */
    cursor: pointer; /* Change cursor to pointer on hover */
  }

  /* Button hover effect */
  .button:hover {
    background-color: rgb(44, 96, 79); /* Darker green on hover */
  }
  .message-box {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100px;
  background-color: rgb(44, 96, 79); /* Adjust as needed */
  padding: 10px;
  text-align: center;
  border-top: 1px solid #ccc; /* Optional: Add a border at the top of the message box */
  display: flex;
  align-items: center;
  justify-content: center;
}
.message-text {
  color: white; /* Adjust to match the style of other CSS elements */
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif, 'Arial Narrow', Arial, sans-serif; /* Use a sans-serif font */
  font-size: 20px;
}

.progress-bar {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 20px;
  background-color: #dcdcdc5e; /* Adjust as needed */
  animation: shrink 3s linear forwards; /* Animation to shrink the progress bar */
}

@keyframes shrink {
  from {
    width: 100%;
  }
  to {
    width: 0;
  }
}
</style>
