package com.aasjunior.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.aasjunior.todoapp.ui.screens.TodoListScreen
import com.aasjunior.todoapp.ui.theme.TodoAppTheme
import com.aasjunior.todoapp.ui.viewmodels.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        setContent {
            TodoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoListScreen(
                        viewModel = todoViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}