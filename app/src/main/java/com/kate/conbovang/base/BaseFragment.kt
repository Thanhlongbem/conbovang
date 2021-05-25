package com.kate.conbovang.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), View.OnClickListener{

    abstract fun setLayoutId(): Int

    abstract fun initView()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(setLayoutId(), container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun setOnClickListener(vararg ids: View) {
        for (view in ids) view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }

}