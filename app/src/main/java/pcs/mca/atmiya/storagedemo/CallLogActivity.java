package pcs.mca.atmiya.storagedemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CallLogActivity extends AppCompatActivity {

    String cols[]={
            CallLog.Calls._ID,
            CallLog.Calls.TYPE,
            CallLog.Calls.DURATION,
            CallLog.Calls.NUMBER
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log);

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CALL_LOG)
                !=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CALL_LOG},111);
        }
        else bindData();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==111 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            bindData();
    }
    @SuppressLint("MissingPermission")
    private void bindData() {
         Cursor rs = getContentResolver().query(CallLog.Calls.CONTENT_URI,
                cols,null,null,null);
         
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.mylayout2,
                rs,
                new String[]{CallLog.Calls.NUMBER, CallLog.Calls.TYPE,CallLog.Calls.DURATION},
                new int[]{R.id.textView11,R.id.textView12,R.id.textView13},
                0);

         ListView lv = findViewById(R.id.listcalllog);
         lv.setAdapter(adapter);
    }
}











