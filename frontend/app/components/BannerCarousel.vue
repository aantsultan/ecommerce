<template>
  <section class="p-6">
    <Swiper
      :modules="[Navigation, Pagination, Autoplay]"
      :slides-per-view="1"
      :loop="true"
      :autoplay="{ delay: 3000 }"
      pagination
      navigation
      class="rounded-lg overflow-hidden"
    >
      <SwiperSlide v-for="banner in banners" :key="banner.id">
        <img
          :src="banner.image"
          :alt="banner.title"
          class="w-full h-64 object-cover"
        />
      </SwiperSlide>
    </Swiper>
  </section>
</template>

<script setup>
import { Swiper, SwiperSlide } from "swiper/vue";
import { Navigation, Pagination, Autoplay } from "swiper/modules";
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";

const banners = [
  {
    id: 1,
    title: "Promo Elektronik",
    image:
      "https://www.mahdinur.com/wp-content/uploads/2024/01/jualan-online-740x414-2.jpg",
  },
  {
    id: 2,
    title: "Diskon Fashion",
    image: "https://qlobot.com/wp-content/uploads/2023/07/Judul-4.png",
  },
  {
    id: 3,
    title: "Belanja Sehat",
    image:
      "https://techtrendske.co.ke/wp-content/uploads/2017/04/online-market-place.png",
  },
];
</script>
