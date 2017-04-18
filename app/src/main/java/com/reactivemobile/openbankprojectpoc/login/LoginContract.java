package com.reactivemobile.openbankprojectpoc.login;


import com.reactivemobile.openbankprojectpoc.base.BaseInterface;
import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

class LoginContract {
    interface LoginView extends BaseInterface {
        void loginOk(String token);

        MainComponent getMainComponent();
    }

    interface LoginPresenter {
        void doLogin(String username, String password);
    }
}
