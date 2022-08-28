package jp.co.yumemi.android.code_check.utils

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import jp.co.yumemi.android.code_check.R

object DialogUtils {
    fun createLoading(activity: Activity): Dialog {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_loading)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
    fun showErrorNetWorkSystem(
        activity: Activity,
        title: String? = null,
        content: String? = null,
        okText: String? = null
    ): Dialog {
        var dialog = AlertDialog.Builder(activity)
            .setTitle(activity.getString(R.string.error_network_title))
            .setMessage(activity.getString(R.string.error_network_content))
            .setPositiveButton(activity.getString(R.string.close_app), object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                            dialog?.dismiss()
                }
            })
            .setCancelable(false)
            .show()
        return dialog
    }
}