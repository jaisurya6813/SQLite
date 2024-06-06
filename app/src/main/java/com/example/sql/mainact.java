package com.example.sql;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class mainact extends AppCompatActivity {
    private EditText name, dur, track, des;
    private Button bt;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainxml);
        name = findViewById(R.id.ET_name);
        dur = findViewById(R.id.ET_dur);
        track = findViewById(R.id.ET_track);
        des = findViewById(R.id.ET_descrip);
        bt = findViewById(R.id.butt);

        dbHandler = new DBHandler(mainact.this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sname = name.getText().toString();
                String Sdur = dur.getText().toString();
                String Strack = track.getText().toString();
                String Sdes = des.getText().toString();
                if (Sname.isEmpty() || Sdur.isEmpty() || Strack.isEmpty() || Sdes.isEmpty()) {
                    Toast.makeText(mainact.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{
                dbHandler.addNewCourse(Sname, Sdur, Strack, Sdes);
                Toast.makeText(mainact.this, "Course has been added", Toast.LENGTH_SHORT).show();
                name.setText("");
                dur.setText("");
                track.setText("");
                des.setText("");}
            }
        });

    }
}