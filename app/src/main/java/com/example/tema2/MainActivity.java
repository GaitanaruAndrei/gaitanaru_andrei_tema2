package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity  {

private UsersViewModel usersViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private  AppDatabase db;
    EditText nume,nota;
    ArrayList<Users> users2;

            Users user;
    Button adauga;
    Button sterge;
    private AppDatabase data;

    public   UsersRepository usersRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          usersRepository = new UsersRepository(getApplicationContext());

        RecyclerView recyclerView = findViewById(R.id.recycler);
        final MyAdapter userListAdapter = new MyAdapter(this);
        recyclerView.setAdapter(userListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        usersRepository.getAllUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> userss) {
                userListAdapter.setUsers(userss);
            }
        });

        // text fields
         nume = findViewById(R.id.edit1);
        nota = findViewById(R.id.edit2);

        // buttons
        Button add_user_btn = findViewById(R.id.adauga);
        sterge = findViewById(R.id.sterg);

        add_user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = UUID.randomUUID().toString();
                String name = nume.getText().toString();
                int nota_user = Integer.parseInt(nota.getText().toString());
                Users user = new Users(user_id, name, nota_user);
                usersRepository.insert(user);

                Toast.makeText(
                        getApplicationContext(),
                        "Utilizator adaugat",
                        Toast.LENGTH_LONG).show();
            }
        });
        data = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_database").allowMainThreadQueries().build();

        sterge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nr = data.userDao().delete(nume.getText().toString());
                if (nr != 0) {
                    userListAdapter.setUsers(data.userDao().getAll());
                    userListAdapter.notifyDataSetChanged();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nu exista userul", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }





}