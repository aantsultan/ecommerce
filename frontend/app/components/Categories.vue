<template>
  <section class="grid grid-cols-4 gap-4 p-6">
    <div v-for="cat in categories" :key="cat" class="text-center">
      <div class="bg-gray-200 rounded-full w-16 h-16 mx-auto mb-2"></div>
      <p>{{ cat }}</p>
    </div>
  </section>
</template>

<script setup>
const categories = ["Elektronik", "Fashion", "Kesehatan", "Rumah Tangga"];
</script>
