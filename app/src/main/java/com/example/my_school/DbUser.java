package com.example.my_school;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbUser extends SQLiteOpenHelper {
    public DbUser(@Nullable Context context) {
        super(context, "db_users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,login VARCHAR(20),password VARCHAR(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS users;");
            onCreate(db);
    }

    public boolean add(String login,String password)
    {
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("login",login);
            cv.put("password",password);
            db.insert("users",null,cv);
            db.close();
            return  true;
        }catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
    }

    public boolean upadte(String login,String password)
    {
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            //cv.put("login",login);
            cv.put("password",password);
            db.update("user",cv,"login='"+login+"'",null);
            db.close();
            return  true;
        }catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
    }

    public boolean delete(String login)
    {
        try {
            SQLiteDatabase db=this.getWritableDatabase();

            db.delete("user","login='"+login+"'",null);
            db.close();
            return  true;
        }catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
    }

    public List<String> getUsers()
    {
        List<String> list=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();

        try {
            Cursor c=db.query("users",null,null,null,null,null,null);

            if(c!=null && c.getCount()>0)
            {
                c.moveToFirst();
                do {
                    @SuppressLint("Range") String login =c.getString(c.getColumnIndex("login"));
                    list.add(login);
                    c.moveToNext();
                }while (!c.isAfterLast());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }
}
