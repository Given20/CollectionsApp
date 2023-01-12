package com.datacase;

import android.content.Context;
import android.content.Intent;

public class IntentHelper {

    public static void openIntent(Context context, Class passTo){
        //Declare intent with context and class to pass intent to
        Intent i = new Intent(context,passTo);

        //start activity
        context.startActivity(i);

    }

}
