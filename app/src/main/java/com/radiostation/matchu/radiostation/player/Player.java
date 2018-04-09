package com.radiostation.matchu.radiostation.player;

import com.radiostation.matchu.radiostation.model.Track;

import io.reactivex.functions.Consumer;

public interface Player {
    void start();
    void watchPlayingTrack(Consumer<Track> onNext);
}
