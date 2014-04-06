package edu.grinnell.grinnellplans;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
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
	.replace(R.id.menu_frame_two, new LeftMenuFragment())
	.commit();

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
