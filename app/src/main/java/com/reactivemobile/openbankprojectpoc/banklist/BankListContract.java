package com.reactivemobile.openbankprojectpoc.banklist;


import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;
import com.reactivemobile.openbankprojectpoc.rest.Banks;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class BankListContract {
    interface BankListView {
        void showBankList(Banks banks);
        MainComponent getMainComponent();
    }

    interface BankListPresenter {
        void getBankList();
    }
}
