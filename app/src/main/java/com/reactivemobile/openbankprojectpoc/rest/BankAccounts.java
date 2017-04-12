package com.reactivemobile.openbankprojectpoc.rest;

import java.util.ArrayList;

/**
 * Created by donalocallaghan on 11/04/2017.
 */

public class BankAccounts {
    public ArrayList<BankAccount> accounts;

    @Override
    public String toString() {
        return "BankAccounts{" +
                "accounts=" + accounts +
                '}';
    }
}
