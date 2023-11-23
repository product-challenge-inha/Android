package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model

import android.annotation.SuppressLint
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

@SuppressLint("SimpleDateFormat")
class Date (
    val year : Int,
    val month : Int,
    val day : Int
) {
    fun getStringOfStart() : String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, day)
        val timeStamp = Timestamp(calendar.timeInMillis)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return dateFormat.format(timeStamp)
    }

    fun getStringOfEnd() : String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, day)
        calendar.add(Calendar.HOUR_OF_DAY, -1)
        val timeStamp = Timestamp(calendar.timeInMillis)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return dateFormat.format(timeStamp)
    }

    companion object {
        fun getInstanceFromCurrent() : Date {
            val calendar = Calendar.getInstance()
            return Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH))
        }

        fun getInstanceFromPrev3Day() : Date {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_MONTH, -3)
            return Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH))
        }
    }
}