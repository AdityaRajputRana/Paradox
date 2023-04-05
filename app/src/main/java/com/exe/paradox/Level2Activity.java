package com.exe.paradox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.exe.paradox.databinding.ActivityLevel2Binding;

public class Level2Activity extends AppCompatActivity {

    ActivityLevel2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevel2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fetchQuestion();
    }

    private void fetchQuestion() {
        binding.questionLayout.setVisibility(View.GONE);
        binding.progressBar.setVisibility(View.VISIBLE);

        //Todo: Continue from here
    }
}