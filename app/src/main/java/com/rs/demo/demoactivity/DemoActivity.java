package com.rs.demo.demoactivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.rs.demo.DemoService;
import com.rs.demo.R;
import com.rs.demo.basemvp.base.BaseActivity;

/**
 * Created by Rs on 2018/6/14.
 */



public class DemoActivity extends BaseActivity<DemoView, DemoPresenter> implements DemoView {
private ImageView image;

      Handler handler =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Log.e("TAG", "handler: "+msg.obj );
                    break;
                default:
                    Log.e("TAG", "handler: "+msg.obj );
                    break;
            }
        }
    };


    private Messenger serviceMessanger;
    private Messenger messenger = new Messenger(handler);

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        image = findViewById(R.id.image);
        initData();

        HandlerThread handlerThread =  new HandlerThread("handlerThread");
        handlerThread.start();
        Handler handler2 = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                Log.e("TAG", "handleMessage: "+Thread.currentThread() +"threadName:"+ Thread.currentThread().getName() );
                Log.e("TAG", "handleMessage: "+Thread.currentThread() );
            }
        };


        Message msg = new Message();
        msg.what=1;
        msg.obj="传递的数据";
        msg.setTarget(handler2);
        msg.sendToTarget();



    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("TAG", "onServiceConnected: "+ componentName );
            serviceMessanger = new Messenger(iBinder);

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            serviceMessanger = null;
            Log.e("TAG", "onServiceDisconnected: "+componentName);

        }
    };

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void initData() {
        final Intent intent  = new Intent(DemoActivity.this,DemoService.class);

        findViewById(R.id.startBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mPresenter.login(1);
//                startService(intent);
            }
        });
        findViewById(R.id.bindBt).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                bindService(intent,connection, 1);


            }
        });
        findViewById(R.id.onbindBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                Message message = Message.obtain();
                message.obj = "这是我传递给服务端的数据";
                message.what = 2;
                message.replyTo = messenger;

                    serviceMessanger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                //unbindService(connection);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
       // service.onUnbind(intent);
    }


    @Override
    public void updata() {

    }

    @Override
    public void dismiss() {

    }
}
