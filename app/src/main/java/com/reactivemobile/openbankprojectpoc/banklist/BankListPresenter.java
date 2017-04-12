package com.reactivemobile.openbankprojectpoc.banklist;


import com.reactivemobile.openbankprojectpoc.rest.Bank;
import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;
import com.reactivemobile.openbankprojectpoc.rest.Banks;
import com.reactivemobile.openbankprojectpoc.rest.RestInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class BankListPresenter implements BankListContract.BankListPresenter {

    private final BankListContract.BankListView bankListView;

    private static final String AUTH_HEADER = "DirectLogin token=\"%s\"";

    private String tokenHeader;

    @Inject
    RestInterface restInterface;

    BankListPresenter(BankListContract.BankListView bankListView) {
        this.bankListView = bankListView;
        bankListView.getMainComponent().inject(this);
        tokenHeader = String.format(AUTH_HEADER, bankListView.getToken());
    }

    @Override
    public void getBankList() {
        Call<Banks> call = restInterface.getBanks();
        call.enqueue(new Callback<Banks>() {
            @Override
            public void onResponse(Call<Banks> call, Response<Banks> response) {
                if (response.code() == 200) {
                    bankListView.showBankList(response.body());
                } else {
                    Timber.e("Error getting bank list, code is %d", response.code());
                }
            }

            @Override
            public void onFailure(Call<Banks> call, Throwable throwable) {
                Timber.e(throwable, "Error getting bank list");
            }
        });
    }

    @Override
    public void getBankAccountsForBank(Bank bank) {
        Timber.d("Getting accounts for %s with authorization %s", bank.full_name, tokenHeader);
        Call<BankAccounts> call = restInterface.getPrivateBankAccountsForBank(bank.id, tokenHeader);
        call.enqueue(new Callback<BankAccounts>() {
            @Override
            public void onResponse(Call<BankAccounts> call, Response<BankAccounts> response) {
                Timber.d("Got response " + response.code());
                if (response.code() == 200) {
                    bankListView.showBankAccountDetails(response.body());
                }
            }

            @Override
            public void onFailure(Call<BankAccounts> call, Throwable throwable) {
                Timber.e(throwable);

            }
        });
    }
}
