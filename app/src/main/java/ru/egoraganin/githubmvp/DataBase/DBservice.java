package ru.egoraganin.githubmvp.DataBase;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Егор on 23.09.2017.
 */

public class DBservice {

    public static <T extends RealmObject> Observable<T> readFirstObjectDB(Class<T> nameClass) {
        final Realm realm = Realm.getDefaultInstance();
        return Observable.just(nameClass).doOnTerminate(new Action() {
            @Override
            public void run() throws Exception {
                realm.close();
            }
        }).map(new Function<Class<T>, T>() {
            @Override
            public T apply(@NonNull Class<T> tClass) throws Exception {
                return realm
                        .where(tClass)
                        .findFirst();
            }
        });


    }

    public static <T extends RealmObject> Observable<T> insertOrUpdateObjectDB(final T object) {
        final Realm realm = Realm.getDefaultInstance();
        return Observable.just(object)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        realm.beginTransaction();
                    }
                })
                .doOnNext(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        realm.insertOrUpdate(t);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        realm.commitTransaction();
                    }
                })
                .doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        realm.close();
                    }
                });
    }


}
