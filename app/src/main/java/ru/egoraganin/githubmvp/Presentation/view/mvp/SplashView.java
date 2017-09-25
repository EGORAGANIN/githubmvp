package ru.egoraganin.githubmvp.Presentation.view.mvp;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface SplashView extends MvpView {

    @StateStrategyType(SingleStateStrategy.class)
    void successAuth();

    @StateStrategyType(SingleStateStrategy.class)
    void errorAuth();
}
