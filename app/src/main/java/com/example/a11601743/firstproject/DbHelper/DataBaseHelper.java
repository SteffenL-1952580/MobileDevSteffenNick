package com.example.a11601743.firstproject.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a11601743.firstproject.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MovieDbApp";

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_MOVIES = "movies";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "title";
    private static final String KEY_YEAR = "year";
    private static final String KEY_DESCRIPTION = "description";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MOVIES_TABLE = "CREATE TABLE " + TABLE_MOVIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_YEAR + " TEXT," +  KEY_DESCRIPTION + " TEXT" + ")";
        db.execSQL(CREATE_MOVIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);

        onCreate(db);
    }

    public void addMovie(Movie movie){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, movie.getTitle());
        values.put(KEY_YEAR, movie.getYear());
        values.put(KEY_DESCRIPTION, movie.getDescription());

        db.insert(TABLE_MOVIES,null,values);
        db.close();
    }

   public List<Movie> getAllMovies(){
        List<Movie> movieList = new ArrayList<>();
        String selectQuery = "SELECT *FROM " + TABLE_MOVIES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

       while (cursor.moveToNext()){
           Movie movie = new Movie();
           movie.setId(Integer.parseInt(cursor.getString(0)));
           movie.setTitle(cursor.getString(1));
           movie.setYear((cursor.getString((2))));
           movie.setDescription(cursor.getString(3));
           movieList.add(movie);
       }

        return movieList;

   }
}
