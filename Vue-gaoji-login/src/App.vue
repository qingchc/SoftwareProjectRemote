<template>
  <component :is="currentComponent" @login-success="switchComponent" />
</template>

<script setup>
import { ref, shallowRef } from 'vue'
import Login from './components/Login.vue'
import Home from './components/Home.vue'

const currentComponent = shallowRef(Login)

const switchComponent = () => {
  currentComponent.value = Home
}
</script>