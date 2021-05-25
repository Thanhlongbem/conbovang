package com.kate.conbovang.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initView()
    }

    abstract fun setLayoutId(): Int

    abstract fun initView()

    fun setOnClickListener(vararg ids: View) {
        for (view in ids) view.setOnClickListener(this)
    }

}