package ru.egoraganin.githubmvp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Егор on 24.09.2017.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }
    //Новости Репозитории и профиль
}
