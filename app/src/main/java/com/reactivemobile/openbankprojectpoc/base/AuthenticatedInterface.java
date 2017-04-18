package com.reactivemobile.openbankprojectpoc.base;

import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public interface AuthenticatedInterface extends BaseInterface {
    MainComponent getMainComponent();
}
