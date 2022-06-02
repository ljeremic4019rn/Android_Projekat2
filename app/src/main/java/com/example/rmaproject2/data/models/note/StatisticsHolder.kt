package com.example.rmaproject2.data.models.note

import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*

class StatisticsHolder(
    var day1: Int,
    var day2: Int,
    var day3: Int,
    var day4: Int,
    var day5: Int
) {

    var boolean: Boolean = true

    fun newDayDataShift() {
        day1 = day2
        day2 = day3
        day3 = day4
        day4 = day5
        day5 = 0
    }

    fun addToCurrentDay() {
        day5 += 1
    }

    fun fillWithExistingData(notes: List<Note>) {//notes reversed, 1st is newest
        if (boolean) {//todo popravi
            val dateNow = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())

            notes.forEach {
//            println("DATUMMM (( $dateNow - ${it.creationDate} )) == $daysBetween")

                when (daysBetween(it.creationDate, dateNow)) {
                    0 -> day5 += 1
                    1 -> day4 += 1
                    2 -> day3 += 1
                    3 -> day2 += 1
                    4 -> day1 += 1
                }
            }
            boolean = false
        }
    }

    private fun daysBetween(d1: Date, d2: Date): Int {
        return ((d2.time - d1.time) / (1000 * 60 * 60 * 24)).toInt()
    }

    fun gettDay1(): Int {
        return day1 * 100 / 2
    }

    fun gettDay2(): Int {
        return day2 * 100 / 2
    }

    fun gettDay3(): Int {
        return day3 * 100 / 2
    }

    fun gettDay4(): Int {
        return day4 * 100 / 2
    }

    fun gettDay5(): Int {
        return day5 * 100 / 2
    }

}