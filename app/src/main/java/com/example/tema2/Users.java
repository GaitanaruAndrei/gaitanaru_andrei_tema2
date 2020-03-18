package com.example.tema2;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;
@Entity(tableName = "Users")
public class Users {
@PrimaryKey
@NonNull
private String id;
@ColumnInfo (name = "nume")
private String nume;
@ColumnInfo (name = "nota")
private Integer nota;


    public Users(String id, String nume, Integer nota) {
        this.id = id;
        this.nume = nume;
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
