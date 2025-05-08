import Mock from 'mockjs'

Mock.mock('/api/login', 'post', function (options) {
  const { username, password } = JSON.parse(options.body)
  if (username === 'admin' && password === '123456') {
    return Mock.mock({
      code: 200,
      message: '登录成功',
      token: '@guid'
    })
  } else {
    return { code: 401, message: '用户名或密码错误' }
  }
})