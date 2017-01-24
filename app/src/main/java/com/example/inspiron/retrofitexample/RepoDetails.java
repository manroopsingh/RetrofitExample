package com.example.inspiron.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RepoDetails extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);

        Intent intent = getIntent();
        //repoList repo = (repoList) intent.getSerializableExtra("repo");
        String name = intent.getStringExtra("repo");


        textView = (TextView) findViewById(R.id.textViewName);

        textView.setText(name);

    }
}
