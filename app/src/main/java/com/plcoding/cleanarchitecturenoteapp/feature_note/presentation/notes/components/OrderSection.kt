package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.GroupBy
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderBy

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    groupBy: GroupBy = GroupBy.Date(OrderBy.Dec),
    onOrderChange: (GroupBy) -> Unit
) {
    DefaultRadioButton(
        text = "Title",
        selected = groupBy is GroupBy.Title,
        onSelected = { onOrderChange(GroupBy.Title(groupBy.orderBy)) }
    )
    Spacer(modifier = Modifier.width(8.dp))
    DefaultRadioButton(
        text = "Date",
        selected = groupBy is GroupBy.Date,
        onSelected = { onOrderChange(GroupBy.Date(groupBy.orderBy)) }
    )
    Spacer(modifier = Modifier.width(8.dp))
    DefaultRadioButton(
        text = "Color",
        selected = groupBy is GroupBy.Color,
        onSelected = { onOrderChange(GroupBy.Color(groupBy.orderBy)) }
    )
    Spacer(modifier = Modifier.height(16.dp))

    Row(modifier = Modifier.fillMaxWidth()) {
        DefaultRadioButton(
            text = "Ascending",
            selected = groupBy.orderBy is OrderBy.Asc,
            onSelected = { onOrderChange(groupBy.copy(OrderBy.Asc)) }
        )
        Spacer(modifier = Modifier.width(8.dp))

        DefaultRadioButton(
            text = "Descending",
            selected = groupBy.orderBy is OrderBy.Dec,
            onSelected = { onOrderChange(groupBy.copy(OrderBy.Dec)) }
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}