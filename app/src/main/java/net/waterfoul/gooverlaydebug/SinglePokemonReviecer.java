package net.waterfoul.gooverlaydebug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import net.waterfoul.gooverlay.interop.FetchData;
import net.waterfoul.gooverlay.interop.IntentStrings;
import net.waterfoul.gooverlay.interop.SinglePokemon;

public class SinglePokemonReviecer extends BroadcastReceiver {
    private static final int DELAY = 10000;
    private Context currentCtx = null;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            loadData(currentCtx);
            handler.postDelayed(this, DELAY);
        }
    };

    @Override
    public void onReceive(Context context, Intent intent) {
        currentCtx = context;
        Log.d("Single", "Recieved " + intent.getAction());
        Toast.makeText(
                context,
                "Broadcast Intent Detected. " + intent.getAction(),
                Toast.LENGTH_LONG
        ).show();
        if(intent.getAction().equals(IntentStrings.SINGLE_POKEMON_OPEN)) {
            loadData(context);
            handler.postDelayed(runnable, DELAY);
        } else {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void loadData(Context ctx) {
        try {
            SinglePokemon data = HomeService.fetchData.fetchSinglePokemon();
            if(data != null) {
                Toast.makeText(
                        ctx,
                        data.getPokemonName() + ' ' +
                        data.getCandyName() + ' ' +
                        data.getEstimatedPokemonLevel() + ' ' +
                        data.getPokemonCP() + ' ' +
                        data.getPokemonHP() + ' ' +
                        data.isFailed(),
                        Toast.LENGTH_LONG
                ).show();
            }
        } catch (RemoteException e) { }
    }

}
