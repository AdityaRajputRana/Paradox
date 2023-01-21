package com.exe.paradox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            Toast.makeText(this, "Null user", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "USer is not null", Toast.LENGTH_SHORT).show();
        }
    }
}