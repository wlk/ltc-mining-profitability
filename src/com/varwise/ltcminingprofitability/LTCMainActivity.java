package com.varwise.ltcminingprofitability;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.varwise.miningprofitabilitylib.MiningActivityBase;

public class LTCMainActivity extends MiningActivityBase {
	public static String ABOUT_MESSAGE = "LTC Mining Profitability \n\nBased on coinchoose.com API";
	private static final String API_BASE = "http://www.coinchoose.com/api.php?base=LTC";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		coinTable = (TableLayout) findViewById(R.id.table);
		sortColumn = getResources().getString(R.string.profitability);
		executeGetCoinProfitabilityTask(API_BASE);	}
	
	@Override
	public void showDialog(String title, String message) {
		super.showDialog(title, message);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(R.id.about == item.getItemId()){
			showDialog("About", ABOUT_MESSAGE);
		}
		else if(R.id.refresh == item.getItemId()){
			executeGetCoinProfitabilityTask(API_BASE);
		}
		
		return true;
	}
	
	@Override
	protected void removePleaseWait() {
		LinearLayout ll = (LinearLayout) findViewById(R.id.mainView);
		ll.removeView(findViewById(R.id.pleaseWaitText));		
	}
}
