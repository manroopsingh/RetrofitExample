package com.example.inspiron.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.inspiron.retrofitexample.pojos.repoList;

public class RepoDetails extends AppCompatActivity {

    private static final String TAG = "RepoDetailsActivity";
    TextView textView, textViewFullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);

        Intent intent = getIntent();
        repoList repo = (repoList) intent.getSerializableExtra("repoOriginalObject");
        String name = intent.getStringExtra("repo");


        textView = (TextView) findViewById(R.id.textViewName);
        textViewFullname=(TextView) findViewById(R.id.textViewFullName);

        textView.setText(repo.getName());
        textViewFullname.setText(repo.getFullName());


    }
}
