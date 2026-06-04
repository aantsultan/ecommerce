<template>
  <section class="grid grid-cols-2 md:grid-cols-4 gap-6 p-6">
    <div
      v-for="product in products"
      :key="product.id"
      class="border rounded-lg p-4"
    >
      <div class="bg-gray-200 h-32 mb-2">
        <img
          :src="product.productDetail[0].file.name"
          :alt="product.productDetail[0].description"
        />
      </div>
      <h3 class="font-bold">{{ product.name }}</h3>
      <p class="text-green-600">Rp {{ product.price }}</p>
      <button class="bg-green-600 text-white px-3 py-1 rounded mt-2">
        Beli
      </button>
    </div>
  </section>
</template>

<script setup lang="ts">
const config = useRuntimeConfig();
const products = ref<any[]>([]);

// fetch data from API
async function fetchData() {
  const response = await $fetch<any>("/products", {
    baseURL: config.public.apiHost,
    method: "GET",
  });
  console.info("products : ", response.data);
  products.value = response.data ?? [];
}

onMounted(() => {
  fetchData();
});
</script>
