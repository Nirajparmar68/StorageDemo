package pcs.mca.atmiya.storagedemo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseFragment extends Fragment {

    SQLiteDatabase db;
    Cursor rs;
    MyHelper helper;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    EditText e1,e2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_database, container, false);

        helper = new MyHelper(getContext());
        db = helper.getWritableDatabase();
        rs = db.rawQuery("SELECT * FROM STUDENT",null);

        b1 = v.findViewById(R.id.button5);
        b2 = v.findViewById(R.id.button6);
        b3 = v.findViewById(R.id.button7);
        b4 = v.findViewById(R.id.button8);
        b5 = v.findViewById(R.id.button9);
        b6 = v.findViewById(R.id.button10);
        b7 = v.findViewById(R.id.button11);
        b8 = v.findViewById(R.id.button12);
        b9 = v.findViewById(R.id.button13);

        e1 = v.findViewById(R.id.editText5);
        e2 = v.findViewById(R.id.editText6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rs.moveToFirst())
                {
                    e1.setText(rs.getString(0));
                    e2.setText(rs.getString(1));
                }
                else
                    Toast.makeText(getContext(), "Record Not Found...!", Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rs.moveToNext())
                {
                    e1.setText(rs.getString(0));
                    e2.setText(rs.getString(1));
                }
                else if(rs.moveToFirst())
                {
                    e1.setText(rs.getString(0));
                    e2.setText(rs.getString(1));
                }
                else
                    Toast.makeText(getContext(), "Record Not Found..!", Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rs.moveToPrevious())
                {
                    e1.setText(rs.getString(0));
                    e2.setText(rs.getString(1));
                }
                else if(rs.moveToLast())
                {
                    e1.setText(rs.getString(0));
                    e2.setText(rs.getString(1));
                }
                else
                    Toast.makeText(getContext(), "Record Not Found..!", Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rs.moveToLast())
                {
                    e1.setText(rs.getString(0));
                    e2.setText(rs.getString(1));
                }
                else
                    Toast.makeText(getContext(), "Record Not Found...!", Toast.LENGTH_SHORT).show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("ROLLNO",e1.getText().toString());
                cv.put("NAME",e2.getText().toString());
                db.insert("STUDENT",null,cv);
                rs.requery();
                clear();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("NAME",e2.getText().toString());
                db.update("STUDENT",cv,"ROLLNO=?",new String[]{e1.getText().toString()});
                rs.requery();
                clear();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.delete("STUDENT","ROLLNO=?",new String[]{e1.getText().toString()});
                rs.requery();
                if(rs.moveToFirst()){
                    e1.setText(rs.getString(0));
                    e2.setText(rs.getString(1));
                }
                else {
                    clear();
                    Toast.makeText(getContext(), "Record Not Found...!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor rs1 = db.rawQuery("SELECT * FROM STUDENT WHERE ROLLNO = ?",
                            new String[]{e1.getText().toString()});
                if(rs1.moveToFirst())
                {
                    e1.setText(rs1.getString(0));
                    e2.setText(rs1.getString(1));
                }
                else
                {
                    Toast.makeText(getContext(), "Record Not Found...!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),ViewAllActivity.class);
                startActivity(i);
            }
        });
        return v;
    }

    private void clear() {
        e1.setText("");
        e2.setText("");
        e1.requestFocus();
    }
}










