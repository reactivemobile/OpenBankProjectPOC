package com.reactivemobile.openbankprojectpoc.rest;

import java.util.ArrayList;

/**
 * Created by donalocallaghan on 11/04/2017.
 */
public class BankAccount {
    public String id;
    public String label;
    public String bank_id;

    public Balance balance;

    public ArrayList<View> views_available;

    public static class View {
        public String id;
        public String short_name;
        public boolean is_public;
    }

    public static class Balance {
        public String currency;
        public String amount;
    }

    @Override
    public String toString() {
        return id;
    }
}
