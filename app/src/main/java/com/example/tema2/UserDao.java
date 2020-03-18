package com.example.tema2;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface UserDao {

    @Query("Select * from Users")
   LiveData< List<Users> >getAllUsers();


    @Delete
    void delete (Users users);


    @Insert
    void insert (Users users);

  @Update
   void update(Users users);

    @Query("DELETE FROM Users WHERE nume LIKE :name")
    int delete(String name);

    @Query("SELECT * FROM users")
    List<Users> getAll();

}
