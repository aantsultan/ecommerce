<template>
  <section class="grid grid-cols-2 md:grid-cols-4 gap-6 p-6">
    <div
      v-for="product in products"
      :key="product.id"
      class="border rounded-lg p-4"
    >
      <div class="bg-gray-200 h-32 mb-2"></div>
      <h3 class="font-bold">{{ product.name }}</h3>
      <p class="text-green-600">Rp {{ product.price }}</p>
      <button class="bg-green-600 text-white px-3 py-1 rounded mt-2">
        Beli
      </button>
    </div>
  </section>
</template>

<script setup>
const products = [
  { id: 1, name: "Laptop Gaming", price: "15.000.000" },
  { id: 2, name: "Sneakers", price: "750.000" },
  { id: 3, name: "Vitamin C", price: "120.000" },
  { id: 4, name: "Blender", price: "450.000" },
];
</script>
