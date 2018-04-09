package com.radiostation.matchu.radiostation.di;

import android.app.Application;

import com.radiostation.matchu.radiostation.RadioApp;
import com.radiostation.matchu.radiostation.di.module.ActivityBuilderModule;
import com.radiostation.matchu.radiostation.di.module.RadioAppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        RadioAppModule.class,
        ActivityBuilderModule.class
})
@Singleton
public interface RadioAppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        RadioAppComponent build();
    }

    void inject(RadioApp app);
}
