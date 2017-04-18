package com.reactivemobile.openbankprojectpoc.bankaccountdetails;

import com.reactivemobile.openbankprojectpoc.base.AuthenticatedInterface;
import com.reactivemobile.openbankprojectpoc.rest.BankAccount;
import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;

/**
 * Created by donalocallaghan on 18/04/2017.
 */

public class BankAccountDetailsContract {

    interface BankAccountDetailsView extends AuthenticatedInterface {
        void showBankAccountDetails(BankAccount bankAccount);

        void showTransferList(String currency, BankAccounts bankAccounts);

        String getToken();
    }

    interface BankAccountDetailsPresenter {
        void getBankAccountDetails(String bankId, String accountID);
    }

}
