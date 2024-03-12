package com.example.my_notes_app.Database;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.my_notes_app.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Notes notes);
    @Query("SELECT * FROM notes ORDER BY ID DESC" )
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title , notes = :notes WHERE ID = :id")
    void update(int id,String title,String notes);
    @Delete
    void delete(Notes notes);
    @Query("UPDATE notes SET pinned = :pin WHERE ID = :id")
    void pin(int id, boolean pin);
}
