package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

sealed class GroupBy(val orderBy: OrderBy){
    class Title(orderBy: OrderBy): GroupBy(orderBy)
    class Color(orderBy: OrderBy): GroupBy(orderBy)
    class Date(orderBy: OrderBy): GroupBy(orderBy)

    fun copy(orderBy: OrderBy): GroupBy{
        return when(this){
            is Title -> Title(orderBy)
            is Color -> Color(orderBy)
            is Date -> Date(orderBy)
        }
    }

}
