package com.reactivemobile.openbankprojectpoc.bankaccountdetails;

import com.reactivemobile.openbankprojectpoc.base.BaseInterface;
import com.reactivemobile.openbankprojectpoc.rest.BankAccount;

/**
 * Created by donalocallaghan on 18/04/2017.
 */

public class BankAccountDetailsContract {

    interface BankAccountDetailsView extends BaseInterface {
        void showBankAccountDetails(BankAccount bankAccount);

        String getToken();
    }

    interface BankAccountDetailsPresenter {
        void getBankAccountDetails(String bankId, String accountID);
    }

}
