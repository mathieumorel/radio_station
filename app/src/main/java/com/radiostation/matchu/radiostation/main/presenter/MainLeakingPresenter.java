package com.radiostation.matchu.radiostation.main.presenter;

import android.widget.TextView;

import com.radiostation.matchu.radiostation.R;
import com.radiostation.matchu.radiostation.main.view.MainViewBinder;
import com.radiostation.matchu.radiostation.model.Track;
import com.radiostation.matchu.radiostation.player.Player;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class MainLeakingPresenter implements MainPresenter {

    private final Player mPlayer;
    private MainViewBinder mMainViewBinder;

    @Inject
    MainLeakingPresenter(Player player) {
        mPlayer = player;
    }

    @Override
    public void onViewAvailable(MainViewBinder binder) {
        mMainViewBinder = binder;
    }

    @Override
    public void listenToRadio(TextView textView) {
        turnRadioOn(textView);
    }

    private void turnRadioOn(TextView textView) {
        mMainViewBinder.disableToggleButton();
        mMainViewBinder.setRadioToggleText(R.string.action_on);
        mPlayer.watchPlayingTrack(track -> textView.setText(track.title));
    }
}
