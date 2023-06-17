package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

sealed class GroupBy(val orderBy: OrderBy){
    class Title(orderBy: OrderBy): GroupBy(orderBy)
    class Color(orderBy: OrderBy): GroupBy(orderBy)
    class Date(orderBy: OrderBy): GroupBy(orderBy)


}
