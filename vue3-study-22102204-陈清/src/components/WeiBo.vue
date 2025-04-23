<template>
    <div>
        <h1>{{ upName }}</h1>
        <p>{{ blogContent }}</p>
        <button>转发：{{ forward }}</button>
        <button>评论：{{ reply }}</button>
        <button>点赞：{{ like }}</button>
        <button @click="$emit('turn-big', 0.1)">放大</button>
        <button @click="turnSmall">缩小</button>
    </div>
</template>

<script setup>
// const props = defineProps([
//     'upName', 'blogContent',
//      'forward', 'reply', 'like'])

const props = defineProps({
    upName: {
        required: false,
        type: String,
        default: '佚名'
    },
    blogContent: {
        required: true,
        type: [String, Number]
    },
    forward: {
        required: false,
        type: Number,
        default: 0
    },
    reply: {
        required: false,
        type: Number,
        default: 0
    },
    like: {
        required: false,
        type: Number,
        default: 0
    }
})

const emit = defineEmits(['turn-big'])

function turnSmall() {
    emit('turn-big', -0.1)
}
</script>
