package pcs.mca.atmiya.storagedemo;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PreferenceFragment extends Fragment {
    EditText e1,e2;
    Button b1,b2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_preference, container, false);
        e1 = v.findViewById(R.id.editText3);
        e2 = v.findViewById(R.id.editText4);
        b1 = v.findViewById(R.id.button3);
        b2 = v.findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().
                        getSharedPreferences("MYPREFERENCE",Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("RNO",e1.getText().toString());
                ed.putString("NAME",e2.getText().toString());
                ed.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().
                        getSharedPreferences("MYPREFERENCE",Context.MODE_PRIVATE);
                e1.setText(sp.getString("RNO","123"));
                e2.setText(sp.getString("NAME",null));
            }
        });
        return v;
    }

}



