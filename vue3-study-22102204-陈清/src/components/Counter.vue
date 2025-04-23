<template>
    <div>
        <h1>{{ count }}</h1>
        <button @click="$emit('event-name', 1)">+1</button>
        <button @click="decrease()">-1</button>
    </div>
</template>

<script setup>
// const props = defineProps(['count'])

const emit = defineEmits(['event-name'])

function decrease() {
    emit('event-name', -1)
}

const props = defineProps({
    count: {
        required: false,
        type: Number,
        default: 0
    },
    countObj: {
        type: Object,
        required: false,
        default(p) {
            // console.log('没传值')
            // console.log('工厂函数里:', p)
            return {
                message: 'hello'
            }
        }
    },
    countFunc: {
        type: Function,
        required: false,
        default() {
            console.log('countFunc 默认函数')
            return null
        }
    }
})

// console.log('props:', props)
// props.countFunc()
</script>
