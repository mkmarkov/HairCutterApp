package com.sirsdev.haircutter;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Vibrator vibro;
	Button stopStartButton;
	boolean running=false;
	long[] infiniteLoopPattern = {0,60000,0,60000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibro = (Vibrator)  getSystemService(Context.VIBRATOR_SERVICE);
        stopStartButton = (Button) findViewById(R.id.StopStartButton);
        
        stopStartButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stopStartVibration();
			}
		});
    }
    
    private void stopStartVibration()
    {
    	if(!running){
    		vibro.vibrate(infiniteLoopPattern,0);
    		running=true;
    	}else{
    		vibro.cancel();
    		running=false;
    	}
    }   
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	vibro.cancel();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	vibro.cancel();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
