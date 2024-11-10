package com.aasjunior.todoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aasjunior.todoapp.domain.models.todo.Todo
import com.aasjunior.todoapp.ui.components.TodoItem
import com.aasjunior.todoapp.ui.theme.TodoAppTheme
import com.aasjunior.todoapp.ui.viewmodels.TodoViewModel

@Composable
fun TodoListScreen(
    viewModel: TodoViewModel,
    modifier: Modifier = Modifier
){
    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            OutlinedTextField(value = inputText, onValueChange = {
                inputText = it
            })
            Button(onClick = {
                if(inputText.isNotBlank()){
                    viewModel.addTodo(inputText)
                    inputText = ""
                }
            }) {
                Text(text = "Add")
            }
        }

        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it){ index: Int, item: Todo ->
                        TodoItem(item = item, onDelete = {
                            viewModel.deleteTodo(item.id)
                        })
                    }
                }
            )
        }?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items yet"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoListScreenPreview(){
    TodoAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            TodoListScreen(
                viewModel = TodoViewModel(),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
