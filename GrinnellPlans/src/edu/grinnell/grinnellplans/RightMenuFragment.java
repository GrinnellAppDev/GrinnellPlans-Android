package edu.grinnell.grinnellplans;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class RightMenuFragment extends SherlockFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	return inflater.inflate(R.layout.right_sliding_menu, null);
    }
}
