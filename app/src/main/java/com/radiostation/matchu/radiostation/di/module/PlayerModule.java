package com.radiostation.matchu.radiostation.di.module;

import com.radiostation.matchu.radiostation.dummy.DummyTracks;
import com.radiostation.matchu.radiostation.model.Track;
import com.radiostation.matchu.radiostation.player.Player;
import com.radiostation.matchu.radiostation.player.PlayerImpl;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

@Module
public abstract class PlayerModule {

    @Binds
    @Singleton
    abstract Player bindPlayer(PlayerImpl playerImplementation);

    @Provides
    @Named("trackPreviewDuration")
    static long provideTrackPreviewDuration() {
        return TimeUnit.SECONDS.toMillis(5);
    }

    @Provides
    static BehaviorSubject<Track> provideTrackQueueSubject() {
        return BehaviorSubject.create();
    }

    @Provides
    static Observable<Track> provideTrackQueue(@Named("trackPreviewDuration") long trackPreviewDuration) {
        return Observable.fromArray(DummyTracks.sTracks)
                .subscribeOn(Schedulers.newThread())
                .concatMap(s -> Observable.just(s).delay(trackPreviewDuration, TimeUnit.MILLISECONDS))
                .repeat()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
