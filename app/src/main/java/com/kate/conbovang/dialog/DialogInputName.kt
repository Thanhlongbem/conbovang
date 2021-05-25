package com.kate.conbovang.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.PopupMenu
import com.kate.conbovang.R
import kotlinx.android.synthetic.main.dialog_input_name.*

class DialogInputName(context: Context): Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        setContentView(R.layout.dialog_input_name)

        tvInputNameOK.setOnClickListener {
            dismiss()
            onDialogInputNameClick?.onDialogInputNameClick(edtInputNamePer1.text.toString(),
            edtInputNamePer2.text.toString(), edtInputNamePer3.text.toString(), edtInputNamePer4.text.toString(), context)
        }
    }

    interface OnDialogInputNameClick{
        fun onDialogInputNameClick(p1: String, p2: String, p3: String, p4: String, context: Context)
    }

    var onDialogInputNameClick : OnDialogInputNameClick? = null


}