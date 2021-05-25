package com.kate.conbovang.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.kate.conbovang.R
import com.kate.conbovang.utils.AppConstant
import com.kate.conbovang.utils.ConBoPreference
import kotlinx.android.synthetic.main.dialog_input_point.*


class DialogInputPoint(context: Context): Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen){
    var p1 = 0
    var p2 = 0
    var p3 = 0
    var p4 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        setContentView(R.layout.dialog_input_point)
        edtInputPointPer1.hint = ConBoPreference.getString(context, AppConstant.PER1, "Người chơi 1").toString()
        edtInputPointPer2.hint = ConBoPreference.getString(context, AppConstant.PER2, "Người chơi 2").toString()
        edtInputPointPer3.hint = ConBoPreference.getString(context, AppConstant.PER3, "Người chơi 3").toString()
        edtInputPointPer4.hint = ConBoPreference.getString(context, AppConstant.PER4, "Người chơi 4").toString()

        tvInputPointPer1.text = ConBoPreference.getString(context, AppConstant.PER1, "Người chơi 1").toString()
        tvInputPointPer2.text = ConBoPreference.getString(context, AppConstant.PER2, "Người chơi 2").toString()
        tvInputPointPer3.text = ConBoPreference.getString(context, AppConstant.PER3, "Người chơi 3").toString()
        tvInputPointPer4.text = ConBoPreference.getString(context, AppConstant.PER4, "Người chơi 4").toString()

        Log.d("Kateee", ConBoPreference.getString(context, AppConstant.PER1, "Người chơi 1").toString())




        tvInputPointOK.setOnClickListener {
            if(edtInputPointPer1.text.toString().isNotEmpty()) {
                p1 = edtInputPointPer1.text.toString().toInt()
            }
            if(edtInputPointPer2.text.toString().isNotEmpty()) {
                p2 = edtInputPointPer2.text.toString().toInt()
            }
            if(edtInputPointPer3.text.toString().isNotEmpty()) {
                p3 = edtInputPointPer3.text.toString().toInt()
            }
            if(edtInputPointPer4.text.toString().isNotEmpty()) {
                p4 = edtInputPointPer4.text.toString().toInt()
            }
            if(checkInput(p1, p2, p3, p4)) {
                dismiss()
                onDialogInputPointClick?.onDialogInputPointClick(p1.toString(), p2.toString(), p3.toString(), p4.toString(), context)
            } else {
                Toast.makeText(context, "Nhập sai rồi", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun checkInput(p1: Int, p2: Int, p3: Int, p4: Int) : Boolean {
        return (p1 + p2 + p3 + p4) == 0
    }

    interface OnDialogInputPointClick{
        fun onDialogInputPointClick(p1: String, p2: String, p3: String, p4: String, context: Context)
    }

    var onDialogInputPointClick : OnDialogInputPointClick? = null
}