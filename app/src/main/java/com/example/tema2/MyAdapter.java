package com.example.tema2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<Users> users;


    public MyAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (users != null) {
            Users user = users.get(position);
            String nota = Integer.toString(user.getNota());
            String data = user.getNume() +" are nota" + nota;
            holder.setData(data, position);

        } else {

        }

    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        }
        return 0;
    }

    public void setUsers(List<Users> userss) {
        users = userss;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userItemView;
        public Button remove;
        private int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userItemView = itemView.findViewById(R.id.user_view);
            remove= itemView.findViewById(R.id.sterg);
        }

        public void setData(String userText, int position) {
            userItemView.setText(userText);
            this.position = position;
        }



        }
    }

