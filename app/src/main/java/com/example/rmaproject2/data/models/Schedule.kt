package com.example.rmaproject2.data.models

data class Schedule(
    val id: String,
    val subject: String,
    val type: String,
    val professor: String,
    val classroom: String,
    val group: String,
    val day: String,
    val time: String
)
