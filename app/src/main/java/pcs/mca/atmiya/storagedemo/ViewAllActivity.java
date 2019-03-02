package pcs.mca.atmiya.storagedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewAllActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor rs;
    MyHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        helper = new MyHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        rs = db.rawQuery("SELECT ROLLNO _id, ROLLNO, NAME FROM STUDENT",null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                ViewAllActivity.this,
                //android.R.layout.simple_expandable_list_item_2,
                R.layout.mylayout,
                rs,
                new String[]{"ROLLNO","NAME"},
                //new int[]{android.R.id.text1,android.R.id.text2},
                new int[]{R.id.textView,R.id.textView2},
                0
        );
        ListView lv = findViewById(R.id.listview);
        lv.setAdapter(adapter);
    }
}








