import tailwindcss from "@tailwindcss/vite";

// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  compatibilityDate: '2025-07-15',
  devtools: { enabled: true },
  devServer: {
    port: 3001
  },
  css: ['../assets/css/tailwind.css'],
  vite:{
    plugins:[
      tailwindcss(),
    ],
    optimizeDeps: {
      include: [
        '@vue/devtools-core',
        '@vue/devtools-kit',
        'vue-good-table-next',
      ]
    }
  },
  runtimeConfig: {
    public: {
      apiHost: process.env.NUXT_PUBLIC_API_HOST || 'http://localhost:4000'
    }
  },
  plugins: [
    { src: 'plugins/vue-good-table', ssr: false }
  ],
  components:[
    {
      path:'components', pathPrefix: false
    }
  ],
})
