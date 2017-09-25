package ru.egoraganin.githubmvp.UI.activity.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.egoraganin.githubmvp.Presentation.presenter.mvp.SignInPresenter;
import ru.egoraganin.githubmvp.Presentation.view.mvp.SignInView;
import ru.egoraganin.githubmvp.R;

public class SignInActivity extends MvpAppCompatActivity implements SignInView {

    public static final String TAG = "SignInActivity";

    @InjectPresenter
    SignInPresenter mSignInPresenter;

    @BindView(R.id.iv_icon_github)
    ImageView ivIconGithub;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_error)
    TextView tvError;
    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;

    private View.OnClickListener btnSignInListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startSignIn();
        }
    };

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, SignInActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        btnSignIn.setOnClickListener(btnSignInListener);
    }

    @Override
    public void startSignIn() {
        btnSignIn.setEnabled(false);
        mSignInPresenter.singIn(etLogin.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void successSignIn() {
        btnSignIn.setEnabled(true);
        startProfileActivity();
    }

    @Override
    public void errorSingIn() {
        btnSignIn.setEnabled(true);
        showError();
    }

    @Override
    public void showError() {
        tvError.setVisibility(View.VISIBLE);
    }

    private void startProfileActivity(){
        startActivity(new Intent(getBaseContext(), MainActivity.class));
    }
}
