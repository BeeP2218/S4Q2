package com.example.s4q2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1,t2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.edittext);
        t1 = (TextView) findViewById(R.id.textview);
        t2 = (TextView) findViewById(R.id.textview2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream f1 = openFileOutput("text.txt", MODE_PRIVATE);
                    String data = e1.getText().toString();

                    f1.write(data.getBytes(StandardCharsets.UTF_8));

                    t1.setText("" + getFilesDir());
                    f1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream f2 = openFileInput("text.txt");
                    int size = f2.available();
                    byte b[] = new byte[size];
                    f2.read(b);

                    String data = new String(b);
                    StringBuffer sb = new StringBuffer(data);

                    t2.setText("Data from file is:" + sb.toString());
                    f2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}