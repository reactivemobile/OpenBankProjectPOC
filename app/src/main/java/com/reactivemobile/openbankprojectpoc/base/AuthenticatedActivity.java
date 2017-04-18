package com.reactivemobile.openbankprojectpoc.base;

import com.reactivemobile.openbankprojectpoc.OpenBankPOCApplication;
import com.reactivemobile.openbankprojectpoc.dagger.MainComponent;

import static com.reactivemobile.openbankprojectpoc.Constants.INTENT_EXTRA_TOKEN;

/**
 * Created by donalocallaghan on 12/04/2017.
 */

public class AuthenticatedActivity extends BaseActivity {

    public final MainComponent getMainComponent() {
        return ((OpenBankPOCApplication) getApplication()).getMainComponent();
    }

    public final String getToken() {
        return getIntent().getStringExtra(INTENT_EXTRA_TOKEN);
    }
}
