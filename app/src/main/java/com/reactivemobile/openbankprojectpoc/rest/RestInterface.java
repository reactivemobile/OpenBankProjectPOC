package com.reactivemobile.openbankprojectpoc.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * REST interface for the Open Bank {}roject
 */
public interface RestInterface {

    @POST("/my/logins/direct")
    @Headers("Content-Type: application/json")
    Call<DirectLoginResponse> doDirectLogin(@Header("Authorization") String authHeader);

    @GET("obp/v2.2.0/banks")
    Call<Banks> getBanks();

    @GET("obp/v2.2.0/banks/{bank_id}/accounts/private")
    Call<BankAccounts> getPrivateBankAccountsForBank(@Path("bank_id") String bankId, @Header("Authorization") String authHeader);

    @GET("obp/v2.2.0/banks/{bank_id}/accounts/{account_id}/{view_id}/account")
    Call<BankAccount> getBankAccountDetails(@Path("bank_id") String bankId, @Path("account_id") String accountId, @Path("view_id") String viewId, @Header("Authorization") String authHeader);
}
