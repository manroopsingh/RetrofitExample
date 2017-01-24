package com.example.inspiron.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.inspiron.retrofitexample.pojos.repoList;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepoListActivity extends AppCompatActivity {

    private static final String TAG = "RepoListActivityTag";

    List<repoList> repoList1 = new ArrayList<>();
    RepoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);


        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new RepoAdapter(this, repoList1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rx.Observable<List<repoList>> profileObservable = RetroFitHelper.Factory.createObs(username);
        profileObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<repoList>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<repoList> repoLists) {
                        for (repoList r : repoLists) {
                            repoList1.add(r);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

    }
}
