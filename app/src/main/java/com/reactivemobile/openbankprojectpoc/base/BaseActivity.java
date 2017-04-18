package com.reactivemobile.openbankprojectpoc.base;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by donalocallaghan on 18/04/2017.
 */

public class BaseActivity extends AppCompatActivity implements BaseInterface {

    @Override
    public final void showError(String error) {
        Snackbar.make(getWindow().getDecorView().getRootView(), error, Snackbar.LENGTH_SHORT).show();
    }
}
