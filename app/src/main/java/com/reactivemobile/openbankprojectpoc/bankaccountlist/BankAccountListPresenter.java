package com.reactivemobile.openbankprojectpoc.bankaccountlist;

import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;
import com.reactivemobile.openbankprojectpoc.rest.RestInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class BankAccountListPresenter implements BankAccountListContract.BankAccountListPresenter {

    private BankAccountListContract.BankAccountListView bankAccountListView;

    // TODO Merge with other similar activities
    private static final String AUTH_HEADER = "DirectLogin token=\"%s\"";

    private String tokenHeader;

    @Inject
    RestInterface restInterface;

    public BankAccountListPresenter(BankAccountListContract.BankAccountListView bankAccountListView) {
        this.bankAccountListView = bankAccountListView;
        bankAccountListView.getMainComponent().inject(this);
        tokenHeader = String.format(AUTH_HEADER, bankAccountListView.getToken());
    }

    @Override
    public void getBankAccountsForBank(String bankId) {
        Call<BankAccounts> call = restInterface.getPrivateBankAccountsForBank(bankId, tokenHeader);
        call.enqueue(new Callback<BankAccounts>() {
            @Override
            public void onResponse(Call<BankAccounts> call, Response<BankAccounts> response) {
                Timber.d("Got response " + response.code());
                if (response.code() == 200) {
                    bankAccountListView.showBankAccounts(response.body());
                }
            }

            @Override
            public void onFailure(Call<BankAccounts> call, Throwable throwable) {
                Timber.e(throwable);
            }
        });
    }
}
