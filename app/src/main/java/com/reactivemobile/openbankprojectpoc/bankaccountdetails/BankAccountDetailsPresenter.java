package com.reactivemobile.openbankprojectpoc.bankaccountdetails;

import com.reactivemobile.openbankprojectpoc.Model;
import com.reactivemobile.openbankprojectpoc.rest.BankAccount;
import com.reactivemobile.openbankprojectpoc.rest.RestInterface;

import java.math.BigDecimal;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by donalocallaghan on 18/04/2017.
 */

public class BankAccountDetailsPresenter implements BankAccountDetailsContract.BankAccountDetailsPresenter {

    private BankAccountDetailsContract.BankAccountDetailsView bankAccountDetailsView;

    // TODO Merge with other similar activities
    private static final String AUTH_HEADER = "DirectLogin token=\"%s\"";

    private String tokenHeader;

    @Inject
    RestInterface restInterface;

    @Inject
    Model model;

    public BankAccountDetailsPresenter(BankAccountDetailsContract.BankAccountDetailsView bankAccountDetailsView) {
        this.bankAccountDetailsView = bankAccountDetailsView;
        bankAccountDetailsView.getMainComponent().inject(this);
        tokenHeader = String.format(AUTH_HEADER, bankAccountDetailsView.getToken());
    }

    @Override
    public void getBankAccountDetails(String bankId, String accountID) {
        Call<BankAccount> call = restInterface.getBankAccountDetails(bankId, accountID, "owner", tokenHeader);
        call.enqueue(new Callback<BankAccount>() {
            @Override
            public void onResponse(Call<BankAccount> call, Response<BankAccount> response) {
                Timber.d("Got response " + response.code());
                if (response.code() == 200) {
                    bankAccountDetailsView.showBankAccountDetails(response.body());
                    bankAccountDetailsView.showTransferList(response.body().balance.currency, model.bankAccounts.get(bankId));
                }
            }

            @Override
            public void onFailure(Call<BankAccount> call, Throwable throwable) {
                Timber.e(throwable);
            }
        });
    }

    @Override
    public void makeTransfer(String toAccountId, String currency, BigDecimal amount) {

    }
}
