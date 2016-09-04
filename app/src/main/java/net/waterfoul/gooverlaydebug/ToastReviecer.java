package net.waterfoul.gooverlaydebug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ToastReviecer extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Toast", "Recieved " + intent.getAction());
        Toast.makeText(
                context,
                "Broadcast Intent Detected. " + intent.getAction(),
                Toast.LENGTH_LONG
        ).show();
    }

}
