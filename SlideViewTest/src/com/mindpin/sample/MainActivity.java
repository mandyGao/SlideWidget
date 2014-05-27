package com.mindpin.sample;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.mindpin.widget.KCSlideFloatView;
public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/* set it to be full screen */
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

	}

	public void onClick(View view) {

		Log.v("mandy", "onclick.....");
		KCSlideFloatView customDialog = new KCSlideFloatView(this);
		// set owerActivty
		customDialog.setOwnerActivity(this);
		LayoutInflater inflater = getLayoutInflater();
		View popupView = inflater.inflate(R.layout.popup_layout, null);
		Button button = (Button) popupView.findViewById(R.id.testButton);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT)
						.show();

			}
		});
		// customDialog.setFullScreen(true);
		customDialog.setPercentHeight(0.6f);
		customDialog.setScaleValue(0.9f);
		customDialog.setView(popupView);
		customDialog.open();


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
