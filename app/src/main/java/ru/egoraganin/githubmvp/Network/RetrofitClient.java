package ru.egoraganin.githubmvp.Network;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Егор on 22.09.2017.
 */

public class RetrofitClient {

    private static final String baseUrl = "https://api.github.com/";

    private final Retrofit retrofit;

    private static final RetrofitClient ourInstance = new RetrofitClient();

    private RetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }
    public static GitHubApi createGitHubApi(){
        return ourInstance.retrofit.create(GitHubApi.class);
    }
}
