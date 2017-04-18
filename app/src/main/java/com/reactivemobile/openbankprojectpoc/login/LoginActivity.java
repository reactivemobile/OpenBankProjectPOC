package com.reactivemobile.openbankprojectpoc.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.reactivemobile.openbankprojectpoc.OpenBankPOCApplication;
import com.reactivemobile.openbankprojectpoc.R;
import com.reactivemobile.openbankprojectpoc.banklist.BankListActivity;
import com.reactivemobile.openbankprojectpoc.base.BaseActivity;
import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.reactivemobile.openbankprojectpoc.Constants.INTENT_EXTRA_TOKEN;

public class LoginActivity extends BaseActivity implements LoginContract.LoginView {

    @BindView(R.id.username)
    EditText usernameEditText;

    @BindView(R.id.password)
    EditText passwordEditText;

    LoginContract.LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.button)
    void onButtonClick() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (username.length() == 0) {
            usernameEditText.setError("Please enter a username");
            usernameEditText.clearFocus();
            return;
        }
        if (password.length() == 0) {
            passwordEditText.setError("Please enter a password");
            passwordEditText.clearFocus();
            return;
        }

        presenter.doLogin(username, password);
    }

    @Override
    public void loginOk(String token) {
        Intent mainActivityIntent = new Intent(this, BankListActivity.class);
        mainActivityIntent.putExtra(INTENT_EXTRA_TOKEN, token);
        startActivity(mainActivityIntent);
        finish();
    }

    @Override
    public MainComponent getMainComponent() {
        return ((OpenBankPOCApplication) getApplication()).getMainComponent();
    }
}
