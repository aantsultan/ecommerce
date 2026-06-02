<template>
  <div
    v-if="show"
    class="modal-overlay fixed inset-0 flex items-center justify-center bg-black bg-opacity-50"
    @click.self="close"
  >
    <div class="modal-content bg-white rounded-lg shadow-lg w-full max-w-md">
      <!-- Header -->
      <div class="flex justify-between items-center px-4 py-2 border-b">
        <h2 class="text-lg font-semibold">Delete Confirmation</h2>
        <button @click="close" class="text-gray-500 hover:text-gray-700">
          &times;
        </button>
      </div>

      <!-- Content -->
      <div class="px-4 py-3 border-b">
        <br />
        <p class="text-gray-700">
          Do you want to delete this data ({{ name }})?
        </p>
        <br />
      </div>

      <!-- Footer -->
      <div class="flex justify-end space-x-2 px-4 py-2 border-t">
        <button @click="close" class="px-4 py-2 bg-gray-600 rounded text-white">
          Close
        </button>
        <button
          @click="deleteId"
          class="px-4 py-2 bg-red-600 rounded text-white"
        >
          Delete
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
const value = defineProps({
  show: Boolean,
  name: String,
});
const emit = defineEmits(["close", "deleteId"]);

function close() {
  emit("close");
}

function deleteId() {
  emit("deleteId");
}
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  inset: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}
.modal-content {
  padding: 1rem;
  border-radius: 8px;
  min-width: 300px;
}
</style>
