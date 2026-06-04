<template>
  <section class="grid grid-cols-4 gap-4 p-6">
    <div v-for="cat in categories" :key="cat" class="text-center">
      <div class="bg-gray-200 rounded-full w-16 h-16 mx-auto mb-2">
        <img :src="cat.name" :alt="cat.name" />
      </div>
      <p>{{ cat.name }}</p>
    </div>
  </section>
</template>

<script setup lang="ts">
const config = useRuntimeConfig();
const categories = ref<any[]>([]);

// fetch data from API
async function fetchData() {
  const response = await $fetch<any>("/categories", {
    baseURL: config.public.apiHost,
    method: "GET",
  });
  console.info(response.data);
  categories.value = response.data ?? [];
}

onMounted(() => {
  fetchData();
});
</script>
