package com.reactivemobile.openbankprojectpoc.bankaccountlist;

import com.reactivemobile.openbankprojectpoc.base.AuthenticatedInterface;
import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;

/**
 * Created by donalocallaghan on 12/04/2017.
 */
public class BankAccountListContract {
    interface BankAccountListView extends AuthenticatedInterface {
        void showBankAccounts(BankAccounts bankAccounts);

        String getToken();
    }

    interface BankAccountListPresenter {
        void getBankAccountsForBank(String bankId);
    }
}
