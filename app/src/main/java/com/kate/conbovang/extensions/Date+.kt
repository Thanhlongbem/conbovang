@file:Suppress("INACCESSIBLE_TYPE")

package com.kate.conbovang.extensions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

fun Date.dateFrom(day: Int, month: Int, year: Int): Date {
    return GregorianCalendar(year, month, day).time
}

fun Date.day(): Int{
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.DAY_OF_MONTH)
}

fun Date.month(): Int{
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.MONTH)
}

fun Date.yearValue(): Int{
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.YEAR)
}

@SuppressLint("SimpleDateFormat")
fun Date.toString(format: String): String{
    return SimpleDateFormat(format).format(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.toDotString(): String{
    return SimpleDateFormat("dd.MM.yyyy").format(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.fromISO(iso: String): Date{
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(iso)!!
}

@SuppressLint("SimpleDateFormat")
fun Date.toISO(): String{
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(this)
}

fun Date.dateAfter(shift: Int): Date{
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, shift)
    return calendar.time
}

fun Date.dateBefore(shift: Int): Date{
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, -shift)
    return calendar.time
}

fun Date.isWeekendDate(): Boolean {
    val c = Calendar.getInstance()
    c.time = this
    val dayOfWeek = c.get(Calendar.DAY_OF_WEEK)
    return dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY
}
//Handling date to string
