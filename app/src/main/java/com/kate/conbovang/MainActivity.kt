package com.kate.conbovang

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.kate.conbovang.base.BaseActivity
import com.kate.conbovang.dialog.DialogInputName
import com.kate.conbovang.dialog.DialogInputPoint
import com.kate.conbovang.dialog.DialogReset
import com.kate.conbovang.utils.AppConstant
import com.kate.conbovang.utils.ConBoPreference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), DialogInputName.OnDialogInputNameClick, DialogInputPoint.OnDialogInputPointClick, DialogReset.OnDialogReset {
    private lateinit var dialogInputName: DialogInputName
    private lateinit var dialogInputPoint: DialogInputPoint
    private lateinit var dialogReset: DialogReset

    override fun setLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        tvPoint1.text = ConBoPreference.getInt(applicationContext, AppConstant.POINT1, 0).toString()
        tvPoint2.text = ConBoPreference.getInt(applicationContext, AppConstant.POINT2, 0).toString()
        tvPoint3.text = ConBoPreference.getInt(applicationContext, AppConstant.POINT3, 0).toString()
        tvPoint4.text = ConBoPreference.getInt(applicationContext, AppConstant.POINT4, 0).toString()
        tvPer1.text = ConBoPreference.getString(applicationContext, AppConstant.PER1, "Người chơi 1").toString()
        tvPer2.text = ConBoPreference.getString(applicationContext, AppConstant.PER2, "Người chơi 2").toString()
        tvPer3.text = ConBoPreference.getString(applicationContext, AppConstant.PER3, "Người chơi 3").toString()
        tvPer4.text = ConBoPreference.getString(applicationContext, AppConstant.PER4, "Người chơi 4").toString()
        setOnClickListener(tvInputName, tvInputPoint, tvReset)

    }

    override fun onClick(v: View?) {
        v?.apply {
            when(v) {
                tvInputName -> {
                    openInputNameDialog(context)
                }
                tvInputPoint -> {
                    openInputPointDialog(context)
                }
                tvReset -> {
                    openDialogReset(context)
                }
            }
        }
    }

    override fun onDialogInputNameClick(p1: String, p2: String, p3: String, p4: String, context: Context) {
        tvPer1.text = p1
        tvPer2.text = p2
        tvPer3.text = p3
        tvPer4.text = p4
        ConBoPreference.setString(context, AppConstant.PER1, p1)
        ConBoPreference.setString(context, AppConstant.PER2, p2)
        ConBoPreference.setString(context, AppConstant.PER3, p3)
        ConBoPreference.setString(context, AppConstant.PER4, p4)
    }

    override fun onDialogInputPointClick(p1: String, p2: String, p3: String, p4: String, context: Context) {
        ConBoPreference.setInt(context, AppConstant.POINT1, ConBoPreference.getInt(context, AppConstant.POINT1, 0) + p1.toInt())
        ConBoPreference.setInt(context, AppConstant.POINT2, ConBoPreference.getInt(context, AppConstant.POINT2, 0) + p2.toInt())
        ConBoPreference.setInt(context, AppConstant.POINT3, ConBoPreference.getInt(context, AppConstant.POINT3, 0) + p3.toInt())
        ConBoPreference.setInt(context, AppConstant.POINT4, ConBoPreference.getInt(context, AppConstant.POINT4, 0) + p4.toInt())
        tvPoint1.text = ConBoPreference.getInt(context, AppConstant.POINT1, 0).toString()
        tvPoint2.text = ConBoPreference.getInt(context, AppConstant.POINT2, 0).toString()
        tvPoint3.text = ConBoPreference.getInt(context, AppConstant.POINT3, 0).toString()
        tvPoint4.text = ConBoPreference.getInt(context, AppConstant.POINT4, 0).toString()
    }

    override fun onDialogReset(context: Context) {
        resetData(context)
    }

    private fun openInputNameDialog(context: Context) {
        dialogInputName = DialogInputName(context)
        dialogInputName.onDialogInputNameClick = this
        dialogInputName.show()
    }

    private fun openInputPointDialog(context: Context) {
        dialogInputPoint = DialogInputPoint(context)
        dialogInputPoint.onDialogInputPointClick = this
        dialogInputPoint.show()
    }

    private fun openDialogReset(context: Context) {
        dialogReset = DialogReset(context)
        dialogReset.onDialogReset = this
        dialogReset.show()
    }

    private fun resetData(context: Context) {
        ConBoPreference.setInt(context, AppConstant.POINT1, 0)
        ConBoPreference.setInt(context, AppConstant.POINT2, 0)
        ConBoPreference.setInt(context, AppConstant.POINT3, 0)
        ConBoPreference.setInt(context, AppConstant.POINT4, 0)
        tvPoint1.text = ConBoPreference.getInt(context, AppConstant.POINT1, 0).toString()
        tvPoint2.text = ConBoPreference.getInt(context, AppConstant.POINT2, 0).toString()
        tvPoint3.text = ConBoPreference.getInt(context, AppConstant.POINT3, 0).toString()
        tvPoint4.text = ConBoPreference.getInt(context, AppConstant.POINT4, 0).toString()
    }
}