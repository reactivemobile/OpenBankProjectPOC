package com.reactivemobile.openbankprojectpoc.banklist;


import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;
import com.reactivemobile.openbankprojectpoc.rest.Bank;
import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;
import com.reactivemobile.openbankprojectpoc.rest.Banks;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class BankListContract {
    interface BankListView {
        void showBankList(Banks banks);

        void showBankAccountDetails(BankAccounts bankAccounts);

        MainComponent getMainComponent();

        String getToken();
    }

    interface BankListPresenter {
        void getBankList();

        void getBankAccountsForBank(Bank bank);
    }
}
