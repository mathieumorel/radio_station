package com.radiostation.matchu.radiostation;

import android.app.Activity;
import android.app.Application;

import com.radiostation.matchu.radiostation.di.DaggerRadioAppComponent;
import com.radiostation.matchu.radiostation.player.Player;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class RadioApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    Player mPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerRadioAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        mPlayer.start();
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
