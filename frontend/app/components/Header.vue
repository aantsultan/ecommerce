<template>
  <header class="bg-green-600 text-white p-4 flex items-center justify-between">
    <h1 class="text-xl font-bold">T Clone</h1>
    <input
      type="text"
      placeholder="Cari produk..."
      class="w-1/2 px-3 py-2 rounded-md text-black"
    />
    <nav>
      <button class="ml-4">Login</button>
      <NuxtLink to="/register" class="ml-2">Daftar</NuxtLink>
    </nav>
  </header>
</template>
