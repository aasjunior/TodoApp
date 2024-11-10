package com.aasjunior.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aasjunior.todoapp.R
import com.aasjunior.todoapp.domain.models.todo.Todo
import com.aasjunior.todoapp.ui.viewmodels.TodoViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TodoItem(
    item: Todo,
    onDelete: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.weight(1f)
        ){
            TextDate(item.createdAt)
            TextTitle(item.title)
        }
        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete icon",
                tint = Color.White
            )
        }
    }
}

@Composable
fun TextDate(date: Date){
    Text(
        text = simpleDateFormat(date),
        fontSize = 10.sp,
        color = Color.LightGray
    )
}

@Composable
fun TextTitle(text: String){
    Text(
        text = text,
        fontSize = 20.sp,
        color = Color.White
    )
}

fun simpleDateFormat(date: Date): String{
    return SimpleDateFormat("HH:mm:aa, dd/MM", Locale("pt", "BR"))
        .format(date)
}
