package com.yhklsdf.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.UpdateListener
import com.yhklsdf.mvp.model.bean.User
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = User("王泽鹏","photo")
//        user.save(object : SaveListener<String>() {
//            override fun done(p0: String?, p1: BmobException?) {
//                if (p1 == null) {
//                    toast("Success+$p0")
//                } else {
//                    toast("数据更新失败")
//                }
//            }
//        })
        user.name = "景天"
        user.update("84f62fdd70",object : UpdateListener(){
            override fun done(p0: BmobException?) {
                if (p0 == null) {
                    toast("更新成功！")
                }
            }
        })
    }
}
