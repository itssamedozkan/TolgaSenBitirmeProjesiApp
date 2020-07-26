package com.bitirme.thhomesecurity.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.bitirme.thhomesecurity.MainActivity;
import com.bitirme.thhomesecurity.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessageReciever extends FirebaseMessagingService {





    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getData().size() > 0){
            showNotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("message"));

        }


        if (remoteMessage.getNotification() != null){
            showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());

        }

    }

    private RemoteViews getCustomDesign(String title , String message){
        RemoteViews remoteViews=new RemoteViews(getApplicationContext().getPackageName(), R.layout.notification);
        remoteViews.setTextViewText(R.id.Title,title);
        remoteViews.setTextViewText(R.id.Message,message);
        remoteViews.setImageViewResource(R.id.ico,R.drawable.calendar);
        return remoteViews;
    }

    public void showNotification (String title , String message){
        Intent intent = new Intent(this, MainActivity.class);
        String Channel_id = "web_app_channel";
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent  = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder  builder = new NotificationCompat.Builder(getApplicationContext(),Channel_id)
                .setSmallIcon(R.drawable.calendar)
                .setSound(uri)
                .setAutoCancel(true)
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){
            builder = builder.setContent(getCustomDesign(title,message));}
        else{
            builder = builder.setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(R.drawable.calendar);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(Channel_id , "web_app",notificationManager.IMPORTANCE_HIGH);
            notificationChannel.setSound(uri,null);
            notificationManager.createNotificationChannel(notificationChannel);

        }
        notificationManager.notify(0,builder.build());
    }
}
