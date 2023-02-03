package com.exe.paradox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.exe.paradox.rest.api.APIMethods;
import com.exe.paradox.rest.api.interfaces.APIResponseListener;
import com.exe.paradox.rest.response.CreateUserRP;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            return;
        } else {
            Toast.makeText(this, "USer is not null", Toast.LENGTH_SHORT).show();
        }
        APIMethods.createUser(new APIResponseListener<CreateUserRP>() {
            @Override
            public void success(CreateUserRP response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void fail(String code, String message, String redirectLink, boolean retry, boolean cancellable) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}