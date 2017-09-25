package ru.egoraganin.githubmvp.Presentation.view.mvp;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SignInView extends MvpView {

    void startSignIn();

    @StateStrategyType(SkipStrategy.class)
    void successSignIn();

    void errorSingIn();

    void showError();

}
