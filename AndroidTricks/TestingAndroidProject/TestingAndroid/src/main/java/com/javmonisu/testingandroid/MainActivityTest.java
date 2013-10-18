package com.javmonisu.testingandroid;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by javier on 18/10/13.
 * This class is used to do unit testing on Android-dependen objects.
 */
public class MainActivityTest extends TestCase{
    public void testOnCreate() throws Exception {
        Assert.assertEquals(true,true);
    }

    public void testOnCreateOptionsMenu() throws Exception {

    }
    public void testAdd(){
        Assert.assertEquals(Calculator.Add(1, 2), 3);
    }
}
