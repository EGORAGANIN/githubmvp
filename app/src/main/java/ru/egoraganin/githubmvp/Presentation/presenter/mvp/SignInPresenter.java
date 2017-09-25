package ru.egoraganin.githubmvp.Presentation.presenter.mvp;


import android.util.Base64;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import ru.egoraganin.githubmvp.DataBase.DBservice;
import ru.egoraganin.githubmvp.DataBase.model.User;
import ru.egoraganin.githubmvp.Network.GitHubService;
import ru.egoraganin.githubmvp.Network.RetrofitClient;
import ru.egoraganin.githubmvp.Presentation.view.mvp.SignInView;

@InjectViewState
public class SignInPresenter extends MvpPresenter<SignInView> {

    GitHubService gitHubService;

    public SignInPresenter() {
        gitHubService = new GitHubService(RetrofitClient.createGitHubApi());
    }

    public void singIn(String login, String password) {

        String credentials = login + ":" + password;
        final String token = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

        Observable<User> observable = gitHubService.getUser(token);

        observable
                .flatMap(new Function<User, Observable<User>>() {
                    @Override
                    public Observable<User> apply(@NonNull User user) throws Exception {
                        user.setToken(token);
                        return DBservice.insertOrUpdateObjectDB(user);

                    }
                }).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull User user) {
            }

            @Override
            public void onError(@NonNull Throwable e) {
                getViewState().errorSingIn();
            }

            @Override
            public void onComplete() {
                getViewState().successSignIn();
            }
        });
    }
}
