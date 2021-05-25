package com.kate.conbovang.extensions

import android.app.Activity
import android.content.*
import android.net.Uri
import android.view.View
import android.widget.Toast
import com.kate.conbovang.App
import java.lang.Exception
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


fun String.toast(context: Context = App.shared(), length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, length).show()
}

inline fun <reified T : View> Activity.find(id: Int): T = findViewById<T>(id)




fun String?.ifEmptyLetBe(alt: String): String {
    if (this == null){
        return alt
    }
    if (this.trim().isEmpty()) {
        return alt
    }
    return this
}

inline fun <T1 : Any, T2 : Any, R : Any> ifLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

inline fun <T1 : Any, T2 : Any, T3 : Any, R : Any> ifLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    block: (T1, T2, T3) -> R?
): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}


fun Double.format(): String{
    val valueAsBD: BigDecimal = BigDecimal.valueOf(this)
    valueAsBD.setScale(2, BigDecimal.ROUND_HALF_UP)
    val custom = DecimalFormatSymbols()
    custom.decimalSeparator = '.'
    custom.groupingSeparator = ','
    custom.currencySymbol = ""
    val format: DecimalFormat = DecimalFormat.getInstance() as DecimalFormat
    format.decimalFormatSymbols = custom
    return try {format.format(valueAsBD)} catch (e: Exception) {return "$this"}
}

fun Int.format(): String{
    val custom = DecimalFormatSymbols()
    custom.decimalSeparator = '.'
    custom.groupingSeparator = ','
    custom.currencySymbol = ""
    val format: DecimalFormat = DecimalFormat.getInstance() as DecimalFormat
    format.decimalFormatSymbols = custom
    return try {format.format(this)} catch (e: Exception) {return "$this"}
}

fun Float.format(): String{
    val custom = DecimalFormatSymbols()
    custom.decimalSeparator = '.'
    custom.groupingSeparator = ','
    custom.currencySymbol = ""
    val format: DecimalFormat = DecimalFormat.getInstance() as DecimalFormat
    format.decimalFormatSymbols = custom
    return try {format.format(this)} catch (e: Exception) {return "$this"}
}

fun String.toDoubleValue(): Double{
    val custom = DecimalFormatSymbols()
    custom.decimalSeparator = '.'
    custom.groupingSeparator = ','
    custom.currencySymbol = ""
    val format: DecimalFormat = DecimalFormat.getInstance() as DecimalFormat
    format.decimalFormatSymbols = custom
    return try {format.parse(this).toDouble()} catch (e: Exception) {return 0.0}
}

fun Context.call(v: String){
    val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$v"))
    startActivity(callIntent)
}

fun Context.mail(v: String) {
    val intentMail = Intent(Intent.ACTION_SEND)
    intentMail.type = "message/rfc822"
    intentMail.putExtra(Intent.EXTRA_EMAIL, v) // the To mail.
    intentMail.putExtra(Intent.EXTRA_SUBJECT, "Subject goes here")
    intentMail.putExtra(Intent.EXTRA_TEXT, "Content goes here")
    try {
        startActivity(Intent.createChooser(intentMail, "Message to User to do what next"))
    } catch (ex: ActivityNotFoundException) {
        "There are no email clients installed.".toast(this)
    }
}