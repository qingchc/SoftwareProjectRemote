<template>
    <div class="login-container">
      <el-card class="login-card">
        <h2 class="title">用户登录</h2>
        <el-form 
          :model="form" 
          :rules="rules" 
          @submit.prevent="handleLogin"
        >
          <el-form-item prop="username">
            <el-input
              v-model="form.username"
              placeholder="请输入用户名"
              prefix-icon="User"
            />
          </el-form-item>
  
          <el-form-item prop="password">
            <el-input
              v-model="form.password"
              type="password"
              placeholder="请输入密码"
              prefix-icon="Lock"
              show-password
            />
          </el-form-item>
  
          <el-button 
            type="primary" 
            native-type="submit" 
            class="login-btn"
            :loading="loading"
          >
            立即登录
          </el-button>
        </el-form>
      </el-card>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import axios from 'axios'
  import { ElMessage } from 'element-plus'
  
  const emit = defineEmits(['login-success'])
  
  const form = ref({ username: '', password: '' })
  const loading = ref(false)
  
  const rules = {
    username: [{ required: true, message: '用户名不能为空', trigger: 'blur' }],
    password: [{ required: true, message: '密码不能为空', trigger: 'blur' }]
  }
  
  const handleLogin = async () => {
    loading.value = true
    try {
      const res = await axios.post('/api/login', form.value)
      if (res.data.code === 200) {
        ElMessage.success(res.data.message)
        localStorage.setItem('token', res.data.token)
        emit('login-success')
      } else {
        ElMessage.error(res.data.message)
      }
    } catch (err) {
      ElMessage.error('请求失败')
    } finally {
      loading.value = false
    }
  }
  </script>
  
  <style scoped>
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: linear-gradient(45deg, #409EFF, #67C23A);
  }
  
  .login-card {
    width: 400px;
    padding: 20px;
  }
  
  .title {
    text-align: center;
    margin-bottom: 30px;
    color: #303133;
  }
  
  .login-btn {
    width: 100%;
    margin-top: 10px;
  }
  </style>