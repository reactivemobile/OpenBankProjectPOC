package com.reactivemobile.openbankprojectpoc.bankaccountdetails;

import com.reactivemobile.openbankprojectpoc.base.AuthenticatedInterface;
import com.reactivemobile.openbankprojectpoc.rest.BankAccount;

/**
 * Created by donalocallaghan on 18/04/2017.
 */

public class BankAccountDetailsContract {

    interface BankAccountDetailsView extends AuthenticatedInterface {
        void showBankAccountDetails(BankAccount bankAccount);

        String getToken();
    }

    interface BankAccountDetailsPresenter {
        void getBankAccountDetails(String bankId, String accountID);
    }

}
