package com.reactivemobile.openbankprojectpoc.login;

import com.reactivemobile.openbankprojectpoc.BuildConfig;
import com.reactivemobile.openbankprojectpoc.rest.DirectLoginResponse;
import com.reactivemobile.openbankprojectpoc.rest.RestInterface;

import java.util.Locale;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class LoginPresenter implements LoginContract.LoginPresenter {

    private static final String AUTH_HEADER = "DirectLogin username=\"%s\",  password=\"%s\",  consumer_key=\"%s\"";

    private LoginContract.LoginView loginView;

    @Inject
    RestInterface restInterface;

    LoginPresenter(LoginContract.LoginView loginView) {
        this.loginView = loginView;
        loginView.getMainComponent().inject(this);
    }

    @Override
    public void doLogin(String username, String password) {
        String authHeader = String.format(AUTH_HEADER, username, password, BuildConfig.CONSUMER_KEY);
        Call<DirectLoginResponse> call = restInterface.doDirectLogin(authHeader);

        Callback<DirectLoginResponse> callback = new Callback<DirectLoginResponse>() {

            @Override
            public void onResponse(Call<DirectLoginResponse> call, Response<DirectLoginResponse> response) {
                if (response.code() == 200) {
                    loginView.loginOk(response.body().token);
                } else {
                    loginView.showError(String.format(Locale.UK, "Error logging in, response was %d", response.code()));
                }
            }

            @Override
            public void onFailure(Call<DirectLoginResponse> call, Throwable throwable) {
                throwable.printStackTrace();
                loginView.showError(String.format("Error logging in, throwable was %s", throwable.getMessage()));
            }
        };
        call.enqueue(callback);
    }
}
