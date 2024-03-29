package tw.cody.broadcast;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

public class InternetCheckService extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkUtil.getNetworkState(context);
        Dialog dialog = new Dialog(context,
                android.R.style.Theme_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.custom_dialog);
        Button rettry = dialog.findViewById(R.id.retry);

        rettry.setOnClickListener(v -> {
//            ((Activity) context).finish();
            Intent intent1 = new Intent(context, MainActivity.class);
            context.startActivity(intent1);
        });


        if (status.isEmpty() || status.equals("No internet")) {
            dialog.show();
        }


        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();


    }
}