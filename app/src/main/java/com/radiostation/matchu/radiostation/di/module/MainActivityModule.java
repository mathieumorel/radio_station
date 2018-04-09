package com.radiostation.matchu.radiostation.di.module;

import com.radiostation.matchu.radiostation.main.presenter.MainLeakingPresenter;
import com.radiostation.matchu.radiostation.main.presenter.MainPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainActivityModule {

    @Binds
    abstract MainPresenter bindMainPresenter(MainLeakingPresenter mainLeakingPresenter);

}
