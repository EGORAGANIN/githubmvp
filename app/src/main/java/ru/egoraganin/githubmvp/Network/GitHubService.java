package ru.egoraganin.githubmvp.Network;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.egoraganin.githubmvp.DataBase.model.User;

/**
 * Created by Егор on 22.09.2017.
 */

public class GitHubService {

    private GitHubApi gitHubApi;

    public GitHubService(GitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    public Observable<User> getUser(String token) {
        return gitHubApi.getUser(token).observeOn(AndroidSchedulers.mainThread());
    }
}
