package com.aasjunior.todoapp.domain.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aasjunior.todoapp.domain.models.entities.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo ORDER BY createdAt DESC")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("DELETE FROM Todo WHERE id = :id")
    fun deleteTodo(id: Int)
}