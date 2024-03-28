<template>
  <div class="profile-page">
    <div class="profile-header">
      <h2>{{ user.username }}</h2>
      <div class="avatar-container">
        <img :src="user.avatar" alt="Profile Avatar" class="avatar">
        <div class="ring"></div>
    </div>
    </div>
    <div class="profile-details">
      <p>Email: {{ user.email }}</p>
      <!-- Other profile details -->
    </div>
    <div class="completed-tasks">
      <h3>Completed Tasks</h3>
      <p>Total: {{ completedTasks }}</p>
      <!-- Display other task-related information as needed -->
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        username: 'Folke',
        email: 'folke@example.com',
        avatar: '@/assets/folke_avatar.png'
        // Add other user details as needed
      },
      completedTasks: 10 // Example number of completed tasks
    };
  }
}
</script>

<style scoped>
/* Add styles specific to the profile page */
.profile-page {
  background-color: rgba(0, 0, 0, 0.5); /* Translucent black background */
  padding: 1rem; /* Add padding for spacing */
  border-radius: 10px; /* Add border radius for rounded corners */
  color: white; /* Text color */
}

.profile-header {
  display: flex;
  align-items: center;
  margin-bottom: 1rem;
}

/* Component styles */
.avatar-container {
  position: relative; /* Ensure positioning context for the ring */
  display: inline-block; /* Ensure the container only takes as much space as needed */
}

.avatar {
  width: 100px; /* Adjust as needed */
  height: 100px; /* Adjust as needed */
  border-radius: 50%; /* Make the avatar round */
}

.ring {
  position: absolute; /* Position the ring relative to its container */
  top: 0;
  left: 0;
  width: 100%; /* Cover the entire avatar */
  height: 100%; /* Cover the entire avatar */
  border: 4px solid rgb(58, 124, 102); /* Set border color and width */
  border-radius: 50%; /* Make the ring round */
}

.profile-details {
  margin-bottom: 1rem;
}

.completed-tasks {
  margin-top: 1rem; /* Add top margin for spacing */
}
</style>
