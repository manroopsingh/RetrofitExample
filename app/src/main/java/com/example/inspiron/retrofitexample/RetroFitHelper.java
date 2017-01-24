package com.example.inspiron.retrofitexample;

import com.example.inspiron.retrofitexample.pojos.repoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by INSPIRON on 24-Jan-17.
 */

public class RetroFitHelper {

    public static class Factory {
        private static final String BASE_URL = "https://api.github.com";

        public static Retrofit create() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        public static Retrofit createObervable() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build();
        }



        public static Observable<GithubProfile> create(String user){
            Retrofit retrofit = createObervable();
            GithubService service = retrofit.create(GithubService.class);
            return service.getProfileObservable(user);
        }


        public static Observable<List<repoList>> createObs(String user){
            Retrofit retrofit = createObervable();
            GithubService service = retrofit.create(GithubService.class);
            return service.getReposObservable(user);
        }

    }

    public interface GithubService{

//        @GET("/users/{user}/repos")
//        Call<List<ResultAPI>> getRepos(@Path("user") String user);

        @GET("/users/{user}")
        Call<GithubProfile> getProfile(@Path("user") String user);

        @GET("/users/{user}")
        rx.Observable<GithubProfile> getProfileObservable(@Path("user") String user);

        @GET("/users/{user}/repos")
        rx.Observable<List<repoList>> getReposObservable(@Path("user") String user);




    }

}
