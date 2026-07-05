package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout activity1 = findViewById(R.id.activity1);
        Button click = findViewById(R.id.click);
        TextView longText = findViewById(R.id.longText);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button click ", Toast.LENGTH_SHORT).show();
                longText.setText("Simple Click On Button ");
            }
        });

        click.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Button Long click", Toast.LENGTH_SHORT).show();
                longText.setText("Long Click On Button");
                return true;
            }
        });
    }
}