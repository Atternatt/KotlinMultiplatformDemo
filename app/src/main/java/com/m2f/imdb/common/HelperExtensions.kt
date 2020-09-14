package com.m2f.imdb.common

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.m2f.imdb.R


fun Context.showGenericErrorDialog() {
    MaterialAlertDialogBuilder(this)
        .setTitle(R.string.ls_generic_error_title)
        .setMessage(R.string.ls_generic_error)
        .setPositiveButton(R.string.ls_generic_ok, null)
        .create()
        .show()
}