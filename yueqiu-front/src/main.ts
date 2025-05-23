import { createApp } from 'vue'
//import './style.css'
import App from './App.vue'
import Vant from 'vant'
import { createMemoryHistory, createRouter } from 'vue-router'
import {ConfigProvider} from "vant/es";
import routes from "./config/route.ts";
// import 'vant/lib/index.css'

const app = createApp(App);
app.use(Vant);
app.use(ConfigProvider);


const router = createRouter({
    history: createMemoryHistory(),
    routes,
})
app.use(router);
app.mount('#app');




