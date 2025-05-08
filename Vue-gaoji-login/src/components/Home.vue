<template>
    <div class="home-container">
      <h2 class="table-title">学生信息表</h2>
      <el-table :data="students" stripe style="width: 80%; margin: 20px auto">
        <el-table-column prop="id" label="学号" width="180" />
        <el-table-column prop="name" label="姓名" width="180" />
        <el-table-column prop="age" label="年龄" />
        <el-table-column label="操作" width="200">
          <template #default="scope">
            <el-button 
              type="primary" 
              size="small"
              @click="handleEdit(scope.row)"
            >编辑</el-button>
            <el-button 
              type="danger" 
              size="small"
              @click="handleDelete(scope.row.id)"
            >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
  
      <!-- 编辑对话框 -->
      <el-dialog v-model="dialogVisible" title="编辑学生信息">
        <el-form :model="editForm" label-width="80px">
          <el-form-item label="学号">
            <el-input v-model="editForm.id" disabled />
          </el-form-item>
          <el-form-item label="姓名" required>
            <el-input v-model="editForm.name" />
          </el-form-item>
          <el-form-item label="年龄" required>
            <el-input 
              v-model.number="editForm.age" 
              type="number"
              min="1"
              max="100"
            />
          </el-form-item>
        </el-form>
        <template #footer>
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="confirmEdit">确认修改</el-button>
        </template>
      </el-dialog>
    </div>
  </template>
  
  <script setup>
  import { ref, reactive } from 'vue'
  import { ElMessage, ElMessageBox } from 'element-plus'
  
  // 学生数据（响应式）
  const students = ref([
    { id: 1001, name: '张三', age: 20 },
    { id: 1002, name: '李四', age: 22 },
    { id: 1003, name: '王五', age: 21 }
  ])
  
  // 对话框控制
  const dialogVisible = ref(false)
  const editForm = reactive({
    id: '',
    name: '',
    age: null
  })
  
  // 编辑操作
  const handleEdit = (row) => {
    Object.assign(editForm, row)
    dialogVisible.value = true
  }
  
  // 确认修改
  const confirmEdit = () => {
    const index = students.value.findIndex(item => item.id === editForm.id)
    if (index !== -1) {
      students.value[index] = { ...editForm }
      ElMessage.success('修改成功')
      dialogVisible.value = false
    }
  }
  
  // 删除操作
  const handleDelete = (id) => {
    ElMessageBox.confirm('确定要删除该学生记录吗？', '警告', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      students.value = students.value.filter(item => item.id !== id)
      ElMessage.success('删除成功')
    }).catch(() => {
      ElMessage.info('已取消删除')
    })
  }
  </script>
  
  <style scoped>
  .home-container {
    padding: 20px;
    text-align: center;
  }
  .table-title {
    margin: 20px 0;
    color: #303133;
  }
  </style>