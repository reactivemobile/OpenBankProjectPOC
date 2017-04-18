package com.reactivemobile.openbankprojectpoc.dagger;

import com.reactivemobile.openbankprojectpoc.Model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by donalocallaghan on 18/04/2017.
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    public Model provideModel() {
        return new Model();
    }
}
