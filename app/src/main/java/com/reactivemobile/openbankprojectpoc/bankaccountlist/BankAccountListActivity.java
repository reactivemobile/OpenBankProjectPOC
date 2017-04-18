package com.reactivemobile.openbankprojectpoc.bankaccountlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reactivemobile.openbankprojectpoc.R;
import com.reactivemobile.openbankprojectpoc.bankaccountdetails.BankAccountDetailsActivity;
import com.reactivemobile.openbankprojectpoc.base.AuthenticatedActivity;
import com.reactivemobile.openbankprojectpoc.rest.BankAccount;
import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.reactivemobile.openbankprojectpoc.Constants.INTENT_EXTRA_BANK_ACCOUNT_ID;
import static com.reactivemobile.openbankprojectpoc.Constants.INTENT_EXTRA_BANK_ID;
import static com.reactivemobile.openbankprojectpoc.Constants.INTENT_EXTRA_TOKEN;

public class BankAccountListActivity extends AuthenticatedActivity implements BankAccountListContract.BankAccountListView {

    @BindView(R.id.account_list_recyclerview)
    RecyclerView accountListRecyclerView;

    BankAccountListContract.BankAccountListPresenter presenter;
    private String bankId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list_layout);
        ButterKnife.bind(this);

        presenter = new BankAccountListPresenter(this);
        bankId = getIntent().getStringExtra(INTENT_EXTRA_BANK_ID);
        presenter.getBankAccountsForBank(bankId);
    }

    @Override
    public void showBankAccounts(BankAccounts bankAccounts) {
        if (bankAccounts.accounts.size() > 0) {
            accountListRecyclerView.setAdapter(new BankAccountRecyclerViewAdapter(bankAccounts));
        } else {
            Snackbar.make(accountListRecyclerView, "No accounts found for this user at this bank", Snackbar.LENGTH_SHORT).show();
        }
    }

    class BankAccountRecyclerViewAdapter extends RecyclerView.Adapter<BankAccountRecyclerViewAdapter.BankAccountViewHolder> {

        private BankAccounts bankAccounts;

        BankAccountRecyclerViewAdapter(BankAccounts bankAccounts) {
            this.bankAccounts = bankAccounts;
        }

        @Override
        public BankAccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BankAccountViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_bank_account_recyclerview_item, parent, false));
        }

        @Override
        public void onBindViewHolder(BankAccountViewHolder holder, int position) {
            holder.setBankAccount(bankAccounts.accounts.get(position));
        }

        @Override
        public int getItemCount() {
            return bankAccounts.accounts.size();
        }

        class BankAccountViewHolder extends RecyclerView.ViewHolder {
            BankAccountViewHolder(View itemView) {
                super(itemView);
            }

            void setBankAccount(BankAccount bankAccount) {
                ((TextView) itemView).setText(bankAccount.id);
                itemView.setOnClickListener(v -> showAccountDetailsForAccount(bankAccount.id));
            }
        }
    }

    private void showAccountDetailsForAccount(String id) {
        Intent intent = new Intent(this, BankAccountDetailsActivity.class);
        intent.putExtra(INTENT_EXTRA_TOKEN, getToken());
        intent.putExtra(INTENT_EXTRA_BANK_ID, bankId);
        intent.putExtra(INTENT_EXTRA_BANK_ACCOUNT_ID, id);
        startActivity(intent);
    }
}
