<template>
  <div class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-md space-y-4">
    <h5 class="text-3xl font-bold underline">Simple CRUD</h5>
  </div>

  <br/>
  <!-- <div v-if="!loginData">No Data</div>
  <div v-else>
    {{ loginData }}
  </div> -->
  <form
    @submit.prevent="addData"
    class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-md space-y-4"
  >
    <div>
      <label for="name" class="block text-sm font-medium text-gray-700"
        >ID</label
      >
      <input
        v-model="newData.id"
        type="number"
        placeholder="ID"
        class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
      />
    </div>
    <div>
      <label for="name" class="block text-sm font-medium text-gray-700"
        >Name</label
      >
      <input
        v-model="newData.name"
        type="text"
        placeholder="Name"
        class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
      />
    </div>
    <div>
      <label for="name" class="block text-sm font-medium text-gray-700"
        >Address</label
      >
      <input
        v-model="newData.address"
        type="text"
        placeholder="Address"
        class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
      />
    </div>

    <button
      type="submit"
      class="w-full bg-indigo-600 text-white py-2 px-4 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
    >
      Submit
    </button>
  </form>

  <br />

  <div class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-md space-y-4">
    <vue-good-table
      :columns="columns()"
      :rows="rows"/>
  </div>
</template>

<!-- Fetch Data -->
<script setup lang="ts">
const config = useRuntimeConfig();
const loginData = await useFetch("/login", {
  baseURL: config.public.apiHost,
});
const newData = ref({
  id: null,
  name: null,
  address: null,
});

const datas = ref([
  {
    id: null,
    name: null,
    address: null,
  },
]);

const columns = () => [
  {
    label: 'ID',
    field: 'id',
    type: 'number',
  },
  {
    label: 'Name',
    field: 'name',
  },
  {
    label: 'Address',
    field: 'address',
  },
];

const rows = ref([]);

const addData = () => {
  rows.value.push({ ...newData.value });
};
</script>