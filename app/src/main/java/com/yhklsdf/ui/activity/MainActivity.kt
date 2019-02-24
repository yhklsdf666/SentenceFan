package com.yhklsdf.ui.activity

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.UpdateListener
import com.yhklsdf.R
import com.yhklsdf.base.BaseActivity
import com.yhklsdf.mvp.model.bean.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity() {

    private val BOTTOM_INDEX = "bottom_index"

    override fun attachLayoutRes() = R.layout.activity_main

    override fun initData() {
    }

    override fun initView() {
        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }

        initDrawerLayout()

        bottom_navigation.run {
            //设置底部图标和字体都显示并去掉点击动画
            labelVisibilityMode = 1
        }
    }

    private fun initDrawerLayout(){
        main_drawer_layout.run {
            var toggle = ActionBarDrawerToggle(
                    this@MainActivity,
                    this,
                    toolbar
                    , R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close)
            addDrawerListener(toggle)
            toggle.syncState()
        }
    }

    override fun start() {
    }
}
