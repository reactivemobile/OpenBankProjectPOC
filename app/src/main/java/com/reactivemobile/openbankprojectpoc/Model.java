package com.reactivemobile.openbankprojectpoc;

import com.reactivemobile.openbankprojectpoc.rest.BankAccounts;
import com.reactivemobile.openbankprojectpoc.rest.Banks;

import java.util.HashMap;

/**
 * Created by donalocallaghan on 18/04/2017.
 */

public class Model {
    public HashMap<String, BankAccounts> bankAccounts = new HashMap<>();
    public Banks banks;
}
