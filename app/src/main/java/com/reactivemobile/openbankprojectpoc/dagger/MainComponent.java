package com.reactivemobile.openbankprojectpoc.dagger;


import com.reactivemobile.openbankprojectpoc.bankaccountdetails.BankAccountDetailsPresenter;
import com.reactivemobile.openbankprojectpoc.bankaccountlist.BankAccountListPresenter;
import com.reactivemobile.openbankprojectpoc.banklist.BankListPresenter;
import com.reactivemobile.openbankprojectpoc.login.LoginPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by donalocallaghan on 11/04/2017.
 */
@Singleton
@Component(modules = {RestModule.class})
public interface MainComponent {

    void inject(LoginPresenter loginPresenter);

    void inject(BankListPresenter bankListPresenter);

    void inject(BankAccountListPresenter bankAccountListPresenter);

    void inject(BankAccountDetailsPresenter bankAccountDetailsPresenter);
}
