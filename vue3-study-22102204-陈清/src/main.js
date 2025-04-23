import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import 'element-plus/dist/index.css'

const app = createApp(App)

app.use(ElementPlus)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

app.directive('focus', {
    mounted(el, binding) {
        el.focus()
    }
})

app.directive('debounce', {
    mounted(el, binding) {
        // 防抖指令实现
        let timeout = null
        el.addEventListener('input', () => {
            if (timeout) {
                clearTimeout(timeout)
                timeout = null
            }
            timeout = setTimeout(
                () => {
                    binding.value()
                },
                parseInt(binding.arg) || 2000
            )
        })
    }
})

app.directive('debounce2', {
    mounted(el, binding) {
        // 防抖指令实现
        let timeout = null
        el.addEventListener('input', () => {
            if (timeout) {
                clearTimeout(timeout)
                timeout = null
            }
            timeout = setTimeout(
                () => {
                    binding.value.func()
                },
                parseInt(binding.value.delay) || 2000
            )
        })
    }
})

app.directive('limit', {
    mounted(el, binding) {
        el.addEventListener('input', () => {
            const value = el.value
            if (value.length > 10) {
                el.value = value.slice(0, 10)
            }
        })
    }
})

app.directive('limitback', {
    mounted(el, binding) {
        el.addEventListener('input', () => {
            const value = el.value
            const valueLen = value.length
            if (valueLen > 10) {
                el.value = value.slice(valueLen - 10, valueLen)
            }
        })
    }
})

app.directive('permission', (el, binding) => {
    const buttonType = el.innerText
    const role = binding.value
    if (role != 'teacher' && role != 'admin') {
        if (buttonType != '查看') {
            // el.style.display = 'none'
            el.remove()
        }
    } else if (role == 'teacher') {
        if (buttonType == '修改') {
            el.style.display = ''
        }
    } else {
        el.style.display = ''
    }
})

app.mount('#app')

window.app = app
