package de.maaxgr.hochschule.hochschulappimprovements.entity

data class TimetableEntry(
    val subjectName: String,
    val time: String,
    val room: String,
    val lecturer: String,
    val description: String
)