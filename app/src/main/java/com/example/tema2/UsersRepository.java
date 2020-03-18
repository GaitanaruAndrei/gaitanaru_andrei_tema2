package com.example.tema2;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersRepository {

    public UserDao userDao;
    private LiveData<List<Users>> allUsers;

    public UsersRepository(Context context)
    {
        AppDatabase database = AppDatabase.getUsersDatabase(context);
        userDao = database.userDao();
        allUsers=userDao.getAllUsers();

    }

    public  void insert (Users users)
    {
        new InsertUsersAsyncTask(userDao).execute(users);
    }

    public void update(Users users)

    {
        new UpdateUsersAsyncTask(userDao).execute(users);
    }

    public void delete(Users users)
    {
        new DeleteAsyncTask(userDao).execute(users);
    }

    public LiveData<List<Users>> getAllUsers(){
        return allUsers;
    }

    private static class InsertUsersAsyncTask extends AsyncTask<Users,Void,Void>{
        private UserDao userDao;

        private InsertUsersAsyncTask(UserDao userDao)
        {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Users... users) {
            userDao.insert(users[0]);
            return null;
        }
    }
    private static class UpdateUsersAsyncTask extends AsyncTask<Users,Void,Void>{
        private UserDao userDao;

        private UpdateUsersAsyncTask(UserDao userDao)
        {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Users... users) {
            userDao.update(users[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<Users,Void,Void>{
        private UserDao userDao;

        private DeleteAsyncTask(UserDao userDao)
        {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Users... users) {
            userDao.delete(users[0]);
            return null;
        }
    }





}
