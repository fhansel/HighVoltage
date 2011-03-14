package com.beanie.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DragDrop extends Activity implements OnTouchListener {

	private final static int START_DRAGGING = 0;
	private final static int STOP_DRAGGING = 1;

	private Button btn;
	private FrameLayout layout;
	private int status;
	private LayoutParams params;

	private ImageButton image, android;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		layout = (FrameLayout) findViewById(R.id.LinearLayout01);
		// layout.setOnTouchListener(this);

		btn = (Button) findViewById(R.id.person);
		android = (ImageButton) findViewById(R.id.android);
		android.setDrawingCacheEnabled(true);
		android.setOnTouchListener(this);

		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);

	}

	@Override
	public boolean onTouch(View view, MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			status = START_DRAGGING;
			//image = (ImageButton) new ImageView(this);
			//image.setImageBitmap(android.getDrawingCache());
			//layout.addView(image, params);
		}
		if (me.getAction() == MotionEvent.ACTION_UP) {
			status = STOP_DRAGGING;
			Log.i("Drag", "Stopped Dragging");
		} else if (me.getAction() == MotionEvent.ACTION_MOVE) {
			if (status == START_DRAGGING) {
				System.out.println("Dragging");
				//android.setPadding((int) me.getRawX(), (int) me.getRawY(), 0, 0);
				android.setPadding((int)me.getX(), (int)me.getY(), 0, 0);
				android.invalidate();
			}
		}
		return false;
	}
}