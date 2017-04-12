package com.reactivemobile.openbankprojectpoc.banklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reactivemobile.openbankprojectpoc.OpenBankPOCApplication;
import com.reactivemobile.openbankprojectpoc.R;
import com.reactivemobile.openbankprojectpoc.bankaccountlist.BankAccountListActivity;
import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;
import com.reactivemobile.openbankprojectpoc.rest.Bank;
import com.reactivemobile.openbankprojectpoc.rest.Banks;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.reactivemobile.openbankprojectpoc.Constants.INTENT_EXTRA_BANK_ID;
import static com.reactivemobile.openbankprojectpoc.Constants.INTENT_EXTRA_TOKEN;

public class BankListActivity extends AppCompatActivity implements BankListContract.BankListView {

    @BindView(R.id.bank_recycler_view)
    RecyclerView bankRecyclerView;

    private BankListContract.BankListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);
        ButterKnife.bind(this);

        presenter = new BankListPresenter(this);
        presenter.getBankList();
    }

    @Override
    public void showBankList(Banks banks) {
        bankRecyclerView.setAdapter(new BankAdapter(banks));
    }

    @Override
    public MainComponent getMainComponent() {
        return ((OpenBankPOCApplication) getApplication()).getMainComponent();
    }

    /**
     * Adapter binding a Banks object with the UI
     */
    public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder> {

        Banks banksList;

        BankAdapter(Banks banksList) {
            this.banksList = banksList;
        }

        @Override
        public BankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_bank_recyclerview_item, parent, false));
        }

        @Override
        public void onBindViewHolder(BankViewHolder holder, int position) {
            holder.setBank(banksList.banks.get(position));
        }

        @Override
        public int getItemCount() {
            return banksList.banks.size();
        }

        class BankViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.bank_name)
            TextView bankName;

            @BindView(R.id.bank_logo)
            ImageView bankLogo;

            BankViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            void setBank(Bank bank) {
                bankName.setText(bank.full_name);
                Picasso.with(BankListActivity.this).load(bank.logo).error(R.drawable.ic_error_outline_black_24dp).resize(64, 64).into(bankLogo);
                itemView.setOnClickListener(v -> showAccountsForBank(bank));
            }
        }
    }

    private void showAccountsForBank(Bank bank) {
        Intent intent = new Intent(this, BankAccountListActivity.class);
        intent.putExtra(INTENT_EXTRA_TOKEN, getIntent().getStringExtra(INTENT_EXTRA_TOKEN));
        intent.putExtra(INTENT_EXTRA_BANK_ID, bank.id);
        startActivity(intent);
    }
}
