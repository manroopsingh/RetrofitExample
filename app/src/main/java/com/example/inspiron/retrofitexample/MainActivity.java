package com.example.inspiron.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText_name);


        Retrofit retrofit = RetroFitHelper.Factory.create();
        RetroFitHelper.GithubService service = retrofit.create(RetroFitHelper.GithubService.class);
        Call<GithubProfile> call = service.getProfile("manroopsingh");

        call.enqueue(new Callback<GithubProfile>() {

            @Override
            public void onResponse(Call<GithubProfile> call, Response<GithubProfile> response) {
                GithubProfile profile = response.body();
                Log.d(TAG, "onResponse: " + profile.getName());
            }

            @Override
            public void onFailure(Call<GithubProfile> call, Throwable t) {

            }
        });



    }

    public void ViewRepos(View view) {
        Intent intent = new Intent(this, RepoListActivity.class);
        intent.putExtra("username", editText.getText().toString());
        startActivity(intent);


    }
}
