package com.reactivemobile.openbankprojectpoc.bankaccountdetails;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.reactivemobile.openbankprojectpoc.Constants;
import com.reactivemobile.openbankprojectpoc.R;
import com.reactivemobile.openbankprojectpoc.base.AuthenticatedActivity;
import com.reactivemobile.openbankprojectpoc.rest.BankAccount;
import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by donalocallaghan on 18/04/2017.
 */

public class BankAccountDetailsActivity extends AuthenticatedActivity implements BankAccountDetailsContract.BankAccountDetailsView {

    private String bankId;

    private String accountId;

    private BankAccountDetailsPresenter presenter;

    @BindView(R.id.account_id)
    TextView accountIdTextView;

    @BindView(R.id.account_balance)
    TextView accountBalanceTextView;

    @BindView(R.id.transfer_currency_text_view)
    TextView currencyTextView;

    @BindView(R.id.transfer_to_spinner)
    Spinner transferToSpinner;

    @BindView(R.id.transfer_amount_edit_text)
    EditText transferAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_detail_activity);
        ButterKnife.bind(this);

        this.accountId = getIntent().getStringExtra(Constants.INTENT_EXTRA_BANK_ACCOUNT_ID);
        this.bankId = getIntent().getStringExtra(Constants.INTENT_EXTRA_BANK_ID);
        presenter = new BankAccountDetailsPresenter(this);
        presenter.getBankAccountDetails(bankId, accountId);
    }

    @Override
    public void showBankAccountDetails(BankAccount bankAccount) {
        accountIdTextView.setText(bankAccount.id);
        accountBalanceTextView.setText(bankAccount.balance.currency + bankAccount.balance.amount);
    }

    @Override
    public void showTransferList(String currency, BankAccounts bankAccounts) {
        currencyTextView.setText(currency);
        ArrayAdapter<BankAccount> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bankAccounts.accounts);
        transferToSpinner.setAdapter(arrayAdapter);
    }
}
