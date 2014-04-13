package edu.grinnell.grinnellplans;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	//Set up action bar
	ActionBar mActionBar = getSupportActionBar();
	mActionBar.setCustomView(R.layout.action_bar);
	mActionBar.setDisplayShowCustomEnabled(true);
	mActionBar.setDisplayShowHomeEnabled(false);
	mActionBar.setDisplayHomeAsUpEnabled(false);
	
	setContentView(R.layout.activity_main);
	setBehindContentView(R.layout.menu_frame);
	
	//Set sliding menu options
	SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeDegree(0.35f);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setMenu(R.layout.menu_frame);
        getSupportFragmentManager()
	.beginTransaction()
	.replace(R.id.menu_frame, new LeftMenuFragment())
	.commit();
        
        //Create a second sliding menu on right side
        menu.setSecondaryMenu(R.layout.menu_frame_two);
	getSupportFragmentManager()
	.beginTransaction()
	.replace(R.id.menu_frame_two, new RightMenuFragment())
	.commit();
	
	
	Button leftButton = (Button) findViewById(R.id.openLeftButton);
	Button rightButton = (Button) findViewById(R.id.openRightButton);

	leftButton.setOnClickListener(new OnClickListener(){
	    @Override
	    public void onClick(View arg0) {
		getSlidingMenu().toggle();
	    }
	    
	});
	
	rightButton.setOnClickListener(new OnClickListener(){
	    @Override
	    public void onClick(View arg0) {
		getSlidingMenu().showSecondaryMenu();
	    }
	    
	});
	
	//Set up text fields
	loadPlan();
	
    }

    
    public void loadPlan() {
    	//get local data from JSON
    	String username = "nguyenti";
    	String name = "Super cool person";
    	String update = "4/13/14 1:02AM";
    	String plantext = "What's brown and sticky? A stick.";
    	//set user name
    	TextView un = (TextView) findViewById(R.id.username);
    	un.setText("[" + username + "]");
    	//set last updated
    	TextView date = (TextView) findViewById(R.id.update);
    	date.setText(update);
    	//set name 
    	TextView n = (TextView) findViewById(R.id.name);
    	n.setText(name);
    	//load content of plan
    	EditText editText = (EditText)findViewById(R.id.plan_text);
    	editText.setText(plantext);
    	Button savePlan = (Button) findViewById(R.id.save_plan);
    	savePlan.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                	//save plan
                	EditText editText = (EditText)findViewById(R.id.plan_text);
                	String text = editText.getText().toString();
                	Toast quickGreeting = Toast.makeText(getApplicationContext(), "Saved",
            				Toast.LENGTH_SHORT);
            		quickGreeting.show();
                }

                return false;
            }
        });
    }
    
    
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//	getSupportMenuInflater().inflate(R.menu.main, menu);
//	return true;
//    }
//    
//    @Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case android.R.id.home:
//			toggle();
//			return true;
//		case R.id.list:
//		    showSecondaryMenu();
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}
