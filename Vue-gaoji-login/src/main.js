import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import './mock' // 引入Mock配置

const app = createApp(App)
app.use(ElementPlus)
app.mount('#app')