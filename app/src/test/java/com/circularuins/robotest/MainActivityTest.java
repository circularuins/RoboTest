package com.circularuins.robotest;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import static junit.framework.Assert.assertEquals;

/**
 * Created by circularuins on 2017/12/13.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;
    private TextView tvHoge;
    private Button btnOk;
    private Button btnNext;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
        tvHoge = (TextView)activity.findViewById(R.id.tv_hoge);
        btnOk = (Button)activity.findViewById(R.id.btn_ok);
        btnNext = (Button)activity.findViewById(R.id.btn_next);
    }

    @Test
    public void showHoge() {
        assertEquals("hoge", tvHoge.getText().toString());
    }

    @Test
    public void clickOk() {
        btnOk.performClick();
        assertEquals("fuga", tvHoge.getText().toString());
    }

    @Test
    public void clickNext() {
        btnNext.performClick();
        Intent expectedIntent = new Intent(activity, NextActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }
}