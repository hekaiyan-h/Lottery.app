package com.example.lotteryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //数组保存抽奖名单

        //记录当前索引值

        //定时器 每隔一段时间换一个名字

        init()
    }

    public fun init(){
        lateinit var timer: Timer
        var index = 0
        var names = listOf<String>("rose","jack","merry","tim")
        //设置TextView默认显示为第一个人的名字
        textView.text = names[0]

        //给按钮添加点击事件
        button.setOnClickListener{
            //判断标题是Start还是Stop
            if(button.text.toString() == "Start"){
                button.text = "Stop"
                //创建定时器
                timer = Timer()
                //分配一个定时任务
               timer.schedule(object: TimerTask(){
                   override fun run() {
                       //判断是否越界
                       index = if(index+1 > names.size-1) 0 else index++
                       //取出对应的名字
                       textView.text = names[index]
                   }

               }, 0, 100)
            } else{
                button.text = "Start"
                timer.cancel()
            }
        }
    }
}





