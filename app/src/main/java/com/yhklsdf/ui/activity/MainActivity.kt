package com.yhklsdf.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBarDrawerToggle
import com.yhklsdf.R
import com.yhklsdf.base.BaseActivity
import com.yhklsdf.ext.loge
import com.yhklsdf.http.RetrofitHelper
import com.yhklsdf.rx.SchedulerUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity() {

    private val BOTTOM_INDEX = "bottom_index"

    private val FRAGMENT_WORDLE = 0x01
    
    private var mIndex = FRAGMENT_WORDLE
    
    override fun attachLayoutRes() = R.layout.activity_main

    override fun initData() {
    }

    override fun initView() {
        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }

        initDrawerLayout()

        bottom_navigation.labelVisibilityMode = 1
    }

    override fun start() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState?.getInt(BOTTOM_INDEX)
        }
        super.onCreate(savedInstanceState)
        RetrofitHelper.service.getSentence()
                .compose(SchedulerUtils.ioToMain())
                .subscribe {
                    toast(it.sentence)
                }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(BOTTOM_INDEX,mIndex)
    }

    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
    }

    private fun hideFragments(transaction: FragmentTransaction) {

    }

    private val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {item ->
                return@OnNavigationItemSelectedListener when (item.itemId) {
                    FRAGMENT_WORDLE -> true
                    else -> false
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
}
