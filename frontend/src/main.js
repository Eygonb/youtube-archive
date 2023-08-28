import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import Service from '@/service/';
import { languages, defaultLocale } from "@/i18n";
import { createI18n } from "vue-i18n";

const app = createApp(App);

const messages = Object.assign(languages);

const i18n = createI18n({
	legacy: false,
	locale: localStorage.getItem('lang') || navigator.language.split('-')[0] || defaultLocale,
	fallbackLocale: 'en',
	messages
})

app.config.globalProperties.$ServiceApi = new Service();
app.config.globalProperties.$isDev = Boolean(import.meta.env.MODE === 'develop');
app.use(router);
app.use(i18n);
app.mount('#app');
