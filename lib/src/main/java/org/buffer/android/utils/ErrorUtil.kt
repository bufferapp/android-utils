package org.buffer.android.utils

import android.content.Context
import org.buffer.android.utils.model.ErrorResponse

open class ErrorUtil {

    fun extractErrorMessage(
        context: Context,
        throwable: Throwable?,
        fallback: String
    ): String {
        return if (throwable is ErrorResponse) {
            return throwable.getErrorMessage()?.let {
                if (it.isNotEmpty()) {
                    it
                } else {
                    handleGenericMessage(context, fallback)
                }
            } ?: run {
                handleGenericMessage(context, fallback)
            }
        } else {
            handleGenericMessage(context, fallback)
        }
    }

    private fun handleGenericMessage(
        context: Context,
        fallback: String
    ): String {
        return if (ConnectivityUtil.checkConnectivity(context)) {
            fallback
        } else {
            context.getString(R.string.error_message_internet_connect)
        }
    }
}