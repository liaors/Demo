package com.rs.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Rs on 2018/6/25.
 */

public class DemoService extends Service {
   public LocalBinder demobinder = new LocalBinder();
   private Messenger serviceMessager;
   private Messenger messenger = new Messenger(new Handler(new Handler.Callback() {
       @Override
       public boolean handleMessage(Message message) {
           if(message.what ==2){
               serviceMessager = message.replyTo;
               Message toClientMsg = Message.obtain();
               toClientMsg.obj = "服务器传过来的消息";
               toClientMsg.what =4;
               try {
                   serviceMessager.send(toClientMsg);
               } catch (RemoteException e) {
                   e.printStackTrace();
               }
           }
           return false;
       }
   }));
    public class LocalBinder extends Binder {
      public  DemoService getsc() {
            return DemoService.this;
        }
    }

    public int getCount(){
        return 3;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "in onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand"+intent.getIntExtra("demo",0));

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("TAG", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG", "onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG", "onBind");
        return messenger.getBinder();

    }
}
