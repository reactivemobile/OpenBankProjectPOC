package com.reactivemobile.openbankprojectpoc.base;

import android.support.v7.app.AppCompatActivity;

import com.reactivemobile.openbankprojectpoc.OpenBankPOCApplication;
import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class BaseActivity extends AppCompatActivity {
    public MainComponent getMainComponent() {
        return ((OpenBankPOCApplication) getApplication()).getMainComponent();
    }
}
