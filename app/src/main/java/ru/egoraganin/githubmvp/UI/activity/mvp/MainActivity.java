package ru.egoraganin.githubmvp.UI.activity.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.egoraganin.githubmvp.Presentation.presenter.mvp.MainPresenter;
import ru.egoraganin.githubmvp.Presentation.view.mvp.MainView;
import ru.egoraganin.githubmvp.R;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public static final String TAG = "MainActivity";
    @InjectPresenter
    MainPresenter mMainPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
