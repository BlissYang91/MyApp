package com.by.myapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.by.myapp", appContext.getPackageName());
        String json = "{\"HotWords\":[\"蓝牙电话\",\"能量管理\",\"QQ音乐\",\"媒体中心\",\"自动泊车\",\"行车影像\",\"360\",\"商城\",\"地图导航\",\"咪咕快游\",\"智能场景\",\"爱奇艺\",\"雷石KTV\",\"火山车娱\",\"个人中心\"],\"UserData\":{\"viewCmd::default\":{\"activeStatus\":\"bg\",\"data\":{\"hotInfo\":{\"viewCmd\":\"蓝牙电话|能量管理|QQ音乐|媒体中心|自动泊车|行车影像|360|商城|地图导航|咪咕快游|智能场景|爱奇艺|雷石KTV|火山车娱|个人中心|\"}},\"sceneStatus\":\"default\"}}}";
        System.out.println("ytf ==========");
    }
}