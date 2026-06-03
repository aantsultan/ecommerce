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
    <Modal
      :show="isOpen"
      :name="name"
      :id="id"
      @close="isOpen = false"
      @delete-id="deleteData"
    >
    </Modal>

    <!-- Notifikasi -->
    <Notification :message="notification.message" :type="notification.type" />
  </div>
  <!-- <div>
    <div v-if="pending">Loading...</div>
    <ul v-else>
      <li v-for="user in users" :key="user.id">{{ user.name }}</li>
    </ul>
  </div> -->
</template>

<!-- Fetch Data -->
<script setup lang="ts">
// import
const isOpen = ref(false);
const name = ref("");
const id = ref(0);
const notification = ref({ message: "", type: "success" });

const config = useRuntimeConfig();
// const loginData = await useFetch("/login", {
//   baseURL: config.public.apiHost,
// });
// console.info("loginData : ", loginData.data.value);
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

// const response = useFetch<any>("/users", {
//   baseURL: config.public.apiHost,
//   method: "GET",
// });
// console.info("response: ", response.data.value?.data);
// const rows = ref<any>([]);

const rows = ref<any[]>([]);
const totalRows = ref(0);

// state for server queries
const page = ref(1);
const perPage = ref(10);
const sort = ref<{ field: string; type: string } | null>(null);
const searchTerm = ref("");

// fetch data from API
async function fetchData() {
  const res = await useFetch<any>("/users", {
    query: {
      page: page.value,
      perPage: perPage.value,
      sortField: sort.value?.field,
      sortType: sort.value?.type,
      search: searchTerm.value,
    },
  });
  rows.value = res.data.value.data;
  totalRows.value = res.data.value.total;
}

// event handlers
function onPageChange(params: any) {
  page.value = params.currentPage;
  perPage.value = params.perPage;
  fetchData();
}

function onSortChange(params: any) {
  sort.value = params[0]; // vue-good-table sends array of sort objects
  fetchData();
}

function onSearch(params: any) {
  searchTerm.value = params.query;
  fetchData();
}

// initial load
fetchData();

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
    notification.value = {
      message: "Data tidak boleh kosong !",
      type: "error",
    };
    setTimeout(() => (notification.value.message = ""), 3000);
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

  notification.value = { message: "Data berhasil disimpan!", type: "success" };
  setTimeout(() => (notification.value.message = ""), 3000);
};

const editRow = (row: any) => {
  console.log("Edit row:", row);
  newData.value = row;
};

const deleteRow = (row: any) => {
  console.log("Delete row:", row);
  isOpen.value = true;
  name.value = row.name;
  id.value = row.id;
};

const deleteData = () => {
  console.info("delete id", id.value);
  rows.value = rows.value.filter((r: any) => r.id !== id.value);
  isOpen.value = false;

  notification.value = { message: "Data berhasil dihapus!", type: "success" };
  setTimeout(() => (notification.value.message = ""), 3000);
};
</script>
