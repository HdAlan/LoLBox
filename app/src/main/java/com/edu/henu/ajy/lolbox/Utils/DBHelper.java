package com.edu.henu.ajy.lolbox.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER="create table User("
            +"userAccount varchar(32),"
            +"userPassword varchar(32),"
            +"headImgPath varchar(32),"
            +"uname varchar(32),"
            +"level int,"
            +"focus int,"
            +"fans int,"
            +"thumbsup int)";
    private Context mContext;
    public DBHelper(Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
