package pcs.mca.atmiya.storagedemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileFragment extends Fragment {

    EditText e1,e2;
    Button b1,b2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_file, container, false);
        e1 = v.findViewById(R.id.editText);
        e2 = v.findViewById(R.id.editText2);
        b1 = v.findViewById(R.id.button);
        b2 = v.findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String data = e1.getText().toString()+"\n"+e2.getText().toString();
                    FileOutputStream fos =
                           getActivity().openFileOutput("data.txt",Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fis = getActivity().openFileInput("data.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    String str;
                    while((str=br.readLine())!=null)
                    {
                        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return v;
    }

}
