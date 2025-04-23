import eslintPluginPrettier from 'eslint-plugin-prettier'
import vueParser from 'vue-eslint-parser'
import globals from 'globals'
import vuePlugin from 'eslint-plugin-vue'

// 如果是 TypeScript 项目还需要导入
// import tsParser from '@typescript-eslint/parser'
// import tsPlugin from '@typescript-eslint/eslint-plugin'

export default [
	{
		files: ['**/*.{js,vue}'],
		languageOptions: {
			ecmaVersion: 'latest',
			sourceType: 'module',
			globals: {
				...globals.browser,
				...globals.node
			},
			parser: vueParser,
			parserOptions: {
				// 如果是 TypeScript 项目需要启用
				// parser: tsParser,
				extraFileExtensions: ['.vue']
			}
		},
		plugins: {
			prettier: eslintPluginPrettier,
			vue: vuePlugin // 使用导入的模块
			// 如果是 TypeScript 项目需要添加
			// '@typescript-eslint': tsPlugin
		},
		rules: {
			'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
			'vue/multi-word-component-names': 'off',
			// 'prettier/prettier': [
			//     'error',
			//     {
			//         endOfLine: 'auto',
			//         semi: false,
			//         singleQuote: true,
			//         tabWidth: 4,
			//         trailingComma: 'none',
			//         printWidth: 100,
			//         htmlWhitespaceSensitivity: 'ignore'
			//     }
			// ]
		}
	}
]