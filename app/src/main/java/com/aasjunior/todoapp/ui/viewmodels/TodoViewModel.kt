package com.aasjunior.todoapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aasjunior.todoapp.domain.models.todo.Todo
import com.aasjunior.todoapp.domain.models.todo.TodoManager

class TodoViewModel: ViewModel() {
    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList

    fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo().reversed()
    }

    fun addTodo(title: String){
        TodoManager.addTodo(title)
        getAllTodo()
    }

    fun deleteTodo(id: Int){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }
}