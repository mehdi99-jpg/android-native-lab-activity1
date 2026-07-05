package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class FirstActivity extends AppCompatActivity{
        EditText username, password;
        private GestureDetector gestureDetector;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.first_activity);
            Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
            username = findViewById(R.id.usernameTextView);
            password = findViewById(R.id.passwordTextView);

            gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                private static final int SWIPE_THRESHOLD = 100;
                private static final int SWIPE_VELOCITY_THRESHOLD = 100;

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    if (e1 == null || e2 == null) return false;
                    float diffX = e2.getX() - e1.getX();
                    float diffY = e2.getY() - e1.getY();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffX < 0) {
                                // Swipe left
                                envoyer(null);
                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            gestureDetector.onTouchEvent(ev);
            return super.dispatchTouchEvent(ev);
        }

        public void envoyer(View view) {
            Intent intent = new Intent(this, SecondActivity.class);
            String usernameString = username.getText().toString().trim();
            String passwordString = password.getText().toString().trim();
            if (usernameString.isEmpty() || passwordString.isEmpty()) {
                Toast.makeText(this, getResources().getString(R.string.fillin), Toast.LENGTH_LONG).show();
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("username", username.getText().toString().trim());
                bundle.putString("password", password.getText().toString().trim());
                intent.putExtras(bundle);

                startActivity(intent);
                finish();
            }
        }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(), "onStart",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(), "onReStart",
                Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getBaseContext(), "onStop",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Toast.makeText(getBaseContext(), "onDestroy",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(), "onPause",
                Toast.LENGTH_LONG).show();
    }


    }

