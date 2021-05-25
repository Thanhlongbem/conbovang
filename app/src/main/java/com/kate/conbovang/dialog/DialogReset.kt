package com.kate.conbovang.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import com.kate.conbovang.R
import kotlinx.android.synthetic.main.dialog_reset.*


class DialogReset(context: Context): Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        setContentView(R.layout.dialog_reset)

        tvNo.setOnClickListener {
            dismiss()
        }

        tvYes.setOnClickListener {
            dismiss()
            onDialogReset?.onDialogReset(context)
        }


    }

    interface OnDialogReset{
        fun onDialogReset(context: Context)
    }

    var onDialogReset : OnDialogReset? = null
}