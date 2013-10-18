package com.javmonisu.testingandroid;

import android.test.ActivityUnitTestCase;
import android.widget.TextView;

/**
 * Created by javier on 18/10/13.
 */
public class MainActivitySecondTest extends ActivityUnitTestCase<MainActivity> {

    String text;
    TextView txtText;
    public MainActivitySecondTest(Class<MainActivity> activityClass) {
        super(activityClass);

    }
    public void setUp(){

    }
    public void testPreconditions(){
        assertNotNull(text);
        assertEquals("Incorrect text","Hello",txtText.getText().toString());
    }
    public void testEditTextUI(){
        txtText.setText("Hello");
        assertEquals("Incorrect text","Hello",txtText.getText().toString());
    }
}
