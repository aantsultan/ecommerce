<template>
  <div class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-md space-y-4">
    <h5 class="text-3xl font-bold underline">Simple CRUD</h5>
  </div>

  <br />
  <!-- <div v-if="!loginData">No Data</div>
  <div v-else>
    {{ loginData }}
  </div> -->
  <form
    @submit.prevent="addOrUpdateData"
    class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-md space-y-4"
  >
    <div>
      <label for="name" class="block text-sm font-medium text-gray-700"
        >Name</label
      >
      <input
        v-model="newData.name"
        type="text"
        placeholder="Name"
        :class="[
          'mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm',
          error.name ? 'border-red-500 ring-red-500' : 'border-gray-300',
        ]"
      />
      <span v-if="error.name" class="absolute text-red-500 text-sm mt-1">{{
        error.name
      }}</span>
    </div>
    <br />
    <div>
      <label for="name" class="block text-sm font-medium text-gray-700"
        >Address</label
      >
      <input
        v-model="newData.address"
        type="text"
        placeholder="Address"
        :class="[
          'mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm',
          error.address ? 'border-red-500 ring-red-500' : 'border-gray-300',
        ]"
      />
      <span v-if="error.address" class="absolute text-red-500 text-sm mt-1">{{
        error.address
      }}</span>
    </div>

    <br />

    <button
      type="submit"
      class="w-full bg-indigo-600 text-white py-2 px-4 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
    >
      Submit
    </button>
  </form>

  <br />

  <div class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-md space-y-4">
    <vue-good-table :columns="columns()" :rows="rows">
      <template #table-row="props">
        <span v-if="props.column.field === 'actions'">
          <button
            class="px-2 py-1 bg-blue-500 text-white rounded mr-2"
            @click="editRow(props.row)"
          >
            Edit
          </button>
          <button
            class="px-2 py-1 bg-red-500 text-white rounded"
            @click="deleteRow(props.row)"
          >
            Delete
          </button>
        </span>
      </template>
    </vue-good-table>
  </div>

  <div>
    <Modal :show="isOpen" @close="isOpen = false"> </Modal>
  </div>
</template>

<!-- Fetch Data -->
<script setup lang="ts">
// import
const isOpen = ref(false);

const config = useRuntimeConfig();
const loginData = await useFetch("/login", {
  baseURL: config.public.apiHost,
});
const newData = ref({
  id: 0,
  name: null,
  address: null,
});

const columns = () => [
  {
    label: "Name",
    field: "name",
  },
  {
    label: "Address",
    field: "address",
  },
  {
    label: "Actions",
    field: "actions",
  },
];

const rows = ref<any>([]);

function generateId(): number {
  if (rows.value.length === 0) return 1;
  return Math.max(...rows.value.map((u: any) => u.id ?? 0)) + 1;
}

const error = ref<{ name?: string; address?: string }>({});
const addOrUpdateData = () => {
  let errors = 0;
  error.value = {};
  if (!newData.value.name) {
    error.value.name = "Nama tidak boleh kosong";
    errors++;
  }

  if (!newData.value.address) {
    error.value.address = "Alamat tidak boleh kosong";
    errors++;
  }

  if (errors > 0) {
    return;
  }

  error.value = {};

  const id = newData.value.id;
  if (id == 0) {
    newData.value.id = generateId();
    rows.value.push(newData.value);
  } else {
    const index = rows.value.findIndex((u: any) => u.id === id);
    if (index != -1) {
      rows.value[index] = newData.value;
    }
  }
  // reset data
  newData.value = {
    id: 0,
    name: null,
    address: null,
  };
};

const editRow = (row: any) => {
  console.log("Edit row:", row);
  newData.value = row;
};

const deleteRow = (row: any) => {
  console.log("Delete row:", row);
  isOpen.value = true;
};
</script>
