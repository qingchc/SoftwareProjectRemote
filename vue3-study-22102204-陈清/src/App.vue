<template>
    <BaseLayout>
        <template #[dname]>Footer</template>
        <template #headerSlot="{ text }">
            {{ text }}
        </template>
        <template #default>Main</template>
    </BaseLayout>
    <FancyButton>Submit</FancyButton>
    <StudentInfo />
    <!-- <component :is="components[currentStatus]"></component>
    <Moyu v-if="currentStatus == 'Moyu'" />
    <Work v-else />
    <button @click="switchStatus">切换</button>
    <div>
        <Counter
            v-bind:count="count1"
            @event-name="
                (d) => {
                    count1 += d
                }
            "
        />
        <Counter :count="count2" @event-name="count2Receive" />
        <Counter :count="count3" @event-name="count3Receive" />
        <WeiBo
            :style="{ fontSize: rFontSize + 'em' }"
            v-for="weibo in weiBoList"
            :key="weibo.id"
            :up-name="weibo.upName"
            :blog-content="weibo.blogContent"
            :reply="weibo.reply"
            :forward="weibo.forward"
            :like="weibo.like"
            @turn-big="onTurnBig"
        />
    </div> -->
</template>

<script setup>
import { ref, reactive } from 'vue'
import WeiBo from './components/WeiBo.vue'
import Counter from './components/Counter.vue'
import Work from './components/Work.vue'
import Moyu from './components/Moyu.vue'
import StudentInfo from './components/StudentInfo.vue'
import FancyButton from './components/FancyButton.vue'
import BaseLayout from './components/BaseLayout.vue'

const dname = ref('footerSlot')
const components = {
    Moyu: Moyu,
    Work: Work
}
const currentStatus = ref('Work')

const count1 = ref(3)
const count2 = ref(5)
const count3 = ref(7)
const rFontSize = ref(1)

function switchStatus() {
    currentStatus.value = currentStatus.value == 'Moyu' ? 'Work' : 'Moyu'
}

function onTurnBig(data) {
    rFontSize.value += data
}

function count2Receive(data) {
    count2.value += data
}

function count3Receive(data) {
    count3.value += data
}

const weiBoList = reactive([
    {
        id: 1,
        upName: '人民日报',
        blogContent: '奋力奔跑，也别忘了身边的美好。',
        reply: 666,
        forward: 888,
        like: 777
    },
    {
        id: 2,
        upName: '人民日报',
        blogContent: '祝贺！郑钦文首进迈阿密赛八强！',
        reply: 666,
        forward: 888,
        like: 888
    },
    {
        id: 3,
        upName: '央视新闻',
        blogContent: '大熊猫“福宝”与公众再度见面。',
        reply: 666,
        forward: 888,
        like: 666
    }
])
</script>
