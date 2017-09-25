package ru.egoraganin.githubmvp.Network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.egoraganin.githubmvp.DataBase.model.User;

/**
 * Created by Егор on 21.09.2017.
 */

public interface GitHubApi {

    @GET("/user")
    Observable<User> getUser(@Header("Authorization") String token);

}
