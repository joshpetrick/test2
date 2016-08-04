package com.josh.test.user;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Josh on 7/31/2016.
 */
public class AddUserIntent extends IntentService
{

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     *
     */
    public AddUserIntent() {
        super("AddUserIntent");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}