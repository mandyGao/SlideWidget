package com.mindpin.widget;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

@SuppressLint("NewApi")
public class KCSlideFloatView extends Dialog implements android.view.View.OnClickListener {
	private ImageButton closeButton;
	private FrameLayout frameLayout;
	private View contentView;
	private boolean isFullScreen = false;
	private float percentHeight = 0.6f;
	private float scaleValue = 0.9f;

	public KCSlideFloatView(Context context) {
		super(context, R.style.dialog);
		
	}

    /*
     * if set true the closeButton will gone.
     */
	public void setFullScreen (boolean isFullScreen) {
		this.isFullScreen = isFullScreen;
		
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_style);
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;
		int screenHeight = displayMetrics.heightPixels;
		Log.v("mandy", "screenWidth: " + screenWidth + "screenHeight: " + screenHeight);
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.rootLayout);
		LayoutParams layoutParams = new LayoutParams(screenWidth, (int)(screenHeight *percentHeight));
		
		linearLayout.setLayoutParams(layoutParams); 
		
		closeButton = (ImageButton) findViewById(R.id.closeButton);
		closeButton.setOnClickListener(this);
		frameLayout = (FrameLayout) findViewById(R.id.content);
		if (null != contentView) {
		   frameLayout.addView(contentView);
		}
	}

	// 浮动框组件滑入屏幕
	public void open() {

		Window window = getWindow();
		// 设置显示动画
		window.setWindowAnimations(R.style.main_menu_animstyle);
		window.setGravity(Gravity.BOTTOM);
		setCanceledOnTouchOutside(true);
		show();
		if (isFullScreen) {
			closeButton.setVisibility(View.GONE);
		}
		
		if(getOwnerActivity() != null) {
			getOwnerActivity().getWindow().getDecorView().setScaleX(scaleValue);
	        getOwnerActivity().getWindow().getDecorView().setScaleY(scaleValue);
		}

	}
	@Override
	public void dismiss() {
		super.dismiss();
		 if(getOwnerActivity() != null) {
				getOwnerActivity().getWindow().getDecorView().setScaleX(1.0f);
		        getOwnerActivity().getWindow().getDecorView().setScaleY(1.0f);
			}
	}

	// 浮动框组件滑出屏幕
	public void close() {
		 dismiss();
	}

	// 设置浮动框组件要显示的内容
	public void setView(View view) {
		this.contentView = view;

	}
     /*
      * the dialog will dismiss when the closebutton is clicked.
      * @see android.view.View.OnClickListener#onClick(android.view.View)
      */
	@Override
	public void onClick(View v) {
	       dismiss();
		
	}
    /*
     * 设置浮动组件占屏幕的百分比
     */
	public void setPercentHeight(float percentHeight) {
		this.percentHeight = percentHeight;
	}
    /*
     * 设置屏幕缩小的倍数
     */
	public void setScaleValue(float scaleValue) {
		this.scaleValue = scaleValue;
	}
	
	

}
