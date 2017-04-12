package com.reactivemobile.openbankprojectpoc;

import android.app.Application;

import com.reactivemobile.openbankprojectpoc.dagger.DaggerMainComponent;
import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;
import com.reactivemobile.openbankprojectpoc.dagger.RestModule;

import timber.log.Timber;

/**
 * Created by donalocallaghan on 11/04/2017.
 */

public class OpenBankPOCApplication extends Application {

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder().restModule(new RestModule()).build();
        Timber.plant(new Timber.DebugTree());
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
