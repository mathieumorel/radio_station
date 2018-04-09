package com.radiostation.matchu.radiostation.player;

import com.radiostation.matchu.radiostation.model.Track;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class PlayerImpl implements Player {

    private final BehaviorSubject<Track> mTrackQueueSubject;
    private final Observable<Track> mTrackQueueObs;

    @Inject
    public PlayerImpl(BehaviorSubject<Track> trackQueueSubject, Observable<Track> trackQueueObs) {
        this.mTrackQueueSubject = trackQueueSubject;
        this.mTrackQueueObs = trackQueueObs;
    }

    @Override
    public void start() {
        mTrackQueueObs.subscribe(mTrackQueueSubject);
    }

    @Override
    public void watchPlayingTrack(io.reactivex.functions.Consumer<Track> onNext) {
        mTrackQueueSubject.subscribe(onNext);
    }


}
