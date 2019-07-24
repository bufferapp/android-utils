package org.buffer.android.utils.model

class ErrorResponse @JvmOverloads constructor(
    var code: String? = null,
    var error: String? = null,
    override var message: String? = null
) : Throwable() {

    fun getErrorMessage(): String? {
        return if (!error.isNullOrEmpty()) {
            error
        } else {
            message
        }
    }
}