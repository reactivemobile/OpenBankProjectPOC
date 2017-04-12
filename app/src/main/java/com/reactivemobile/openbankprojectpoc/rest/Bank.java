package com.reactivemobile.openbankprojectpoc.rest;

/**
 * Created by donalocallaghan on 11/04/2017.
 */

public class Bank {

    public String id;
    public String short_name;
    public String full_name;
    public String logo;
    public String website;
    public BankRouting bank_routing;

    public static class BankRouting {
        public String scheme;
        public String address;

        @Override
        public String toString() {
            return "BankRouting{" +
                    "scheme='" + scheme + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", short_name='" + short_name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", logo='" + logo + '\'' +
                ", website='" + website + '\'' +
                ", bank_routing=" + bank_routing +
                '}';
    }
}
