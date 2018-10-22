package com.example.a11601743.firstproject.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.a11601743.firstproject.DetailActivity;
import com.example.a11601743.firstproject.MainActivity;
import com.example.a11601743.firstproject.R;

public class NotificationBuilder extends ContextWrapper {


    public NotificationBuilder(Context base){
        super(base);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Notification.Builder getNotification(String title, String text) {
        Notification.Builder notification = new Notification.Builder(getApplicationContext());
        notification.setContentTitle(title);
        notification.setContentText(text);
        notification.setSmallIcon(R.drawable.noti);
        notification.setAutoCancel(true);
        //notification.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;

        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(resultPendingIntent);
        return notification;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void giveNotification(String title, String text){
        Notification.Builder n = getNotification(title,text);
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,n.build());
    }
}
