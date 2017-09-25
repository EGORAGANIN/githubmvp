package ru.egoraganin.githubmvp.Presentation.presenter.mvp;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.realm.RealmObject;
import ru.egoraganin.githubmvp.DataBase.DBservice;
import ru.egoraganin.githubmvp.DataBase.model.User;
import ru.egoraganin.githubmvp.Presentation.view.mvp.SplashView;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    public void checkAuth(Class<? extends RealmObject> nameClass) {
        DBservice.readFirstObjectDB(nameClass).subscribe(new Observer<RealmObject>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull RealmObject realmObject) {
                User user = (User) realmObject;
                if (user.getToken() != null && user.getLogin() != null) {
                    //onComplete();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("TAG", "onError: ", e);
                getViewState().errorAuth();
            }

            @Override
            public void onComplete() {
                Log.d("TAG", "onComplete: ");
                getViewState().successAuth();
            }
        });
    }

}
