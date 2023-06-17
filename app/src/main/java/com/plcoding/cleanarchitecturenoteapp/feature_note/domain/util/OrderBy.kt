package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

sealed class OrderBy{
    object Asc : OrderBy()
    object Dec : OrderBy()
}
