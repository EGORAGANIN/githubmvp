package ru.egoraganin.githubmvp.UI.activity.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.egoraganin.githubmvp.DataBase.model.User;
import ru.egoraganin.githubmvp.Presentation.presenter.mvp.SplashPresenter;
import ru.egoraganin.githubmvp.Presentation.view.mvp.SplashView;
import ru.egoraganin.githubmvp.R;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    public static final String TAG = "SplashActivity";

    @InjectPresenter
    SplashPresenter mSplashPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashPresenter.checkAuth(User.class);
    }

    @Override
    public void successAuth() {
        startProfileActivity();
    }

    @Override
    public void errorAuth() {
        startSignInActivity();
    }

    private void startProfileActivity(){
        startActivity(new Intent(getBaseContext(), MainActivity.class));
        finish();
    }
    private void startSignInActivity(){
        startActivity(new Intent(getBaseContext(), SignInActivity.class));
        finish();
    }
}
