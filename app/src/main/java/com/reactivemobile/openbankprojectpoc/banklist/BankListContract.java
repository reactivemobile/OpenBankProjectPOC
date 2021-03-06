package com.reactivemobile.openbankprojectpoc.banklist;


import com.reactivemobile.openbankprojectpoc.base.AuthenticatedInterface;
import com.reactivemobile.openbankprojectpoc.rest.Banks;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class BankListContract {
    interface BankListView extends AuthenticatedInterface {
        void showBankList(Banks banks);
    }

    interface BankListPresenter {
        void getBankList();
    }
}
