package com.radiostation.matchu.radiostation.main.presenter;

import android.widget.TextView;

import com.radiostation.matchu.radiostation.main.view.MainViewBinder;

public interface MainPresenter {
    void onViewAvailable(MainViewBinder binder);
    void listenToRadio(TextView textView);
}
