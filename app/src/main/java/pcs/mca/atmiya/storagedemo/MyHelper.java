package pcs.mca.atmiya.storagedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(@Nullable Context context) {
        super(context, "STUDENTDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE STUDENT(ROLLNO INTEGER PRIMARY KEY,NAME TEXT)");
            db.execSQL("INSERT INTO STUDENT(ROLLNO,NAME) VALUES(101,'SACHIN')");
            db.execSQL("INSERT INTO STUDENT(ROLLNO,NAME) VALUES(102,'RAHUL')");
            db.execSQL("INSERT INTO STUDENT(ROLLNO,NAME) VALUES(103,'SAURAV')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
