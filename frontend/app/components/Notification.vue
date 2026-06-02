<template>
  <div
    v-if="message"
    class="fixed top-4 right-4 px-4 py-2 rounded shadow-lg text-white"
    :class="{
      'bg-green-600': type === 'success',
      'bg-red-600': type === 'error',
      'bg-blue-600': type === 'info',
    }"
  >
    {{ message }}
  </div>
</template>

<!-- components/Notification.vue -->
<script setup>
const props = defineProps({
  message: String,
  type: {
    type: String,
    default: "success", // success | error | info
  },
});
</script>
