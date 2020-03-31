package org.buffer.android.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.annotation.ColorRes
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat

object CustomTabUtil {

    fun open(
        context: Context,
        uri: Uri,
        @ColorRes color: Int,
        closeBitmap: Bitmap
    ) {
        val intent = buildIntent(context, uri, color, closeBitmap)
        try {
            context.startActivity(intent)
        } catch (error: ActivityNotFoundException) {
            Log.e(
                CustomTabUtil::class.java.name,
                "There was a problem start the browser intent"
            )
        }

    }

    private fun buildIntent(
        context: Context,
        uri: Uri,
        @ColorRes color: Int,
        closeBitmap: Bitmap
    ): Intent {
        val customTabsIntent = CustomTabsIntent.Builder()
            .setToolbarColor(ContextCompat.getColor(context, color))
            .setShowTitle(true)
            .setCloseButtonIcon(closeBitmap)
            .addDefaultShareMenuItem()
            .build()
        return customTabsIntent.intent.apply {
            data = uri
        }
    }
}