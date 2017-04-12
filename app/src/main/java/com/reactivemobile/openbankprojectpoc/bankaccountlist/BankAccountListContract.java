package com.reactivemobile.openbankprojectpoc.bankaccountlist;

import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;
import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;

/**
 * Created by donalocallaghan on 12/04/2017.
 */
public class BankAccountListContract {
    interface BankAccountListView {
        void showBankAccounts(BankAccounts bankAccounts);

        MainComponent getMainComponent();

        String getToken();
    }

    interface BankAccountListPresenter {
        void getBankAccountsForBank(String bankId);
    }
}
