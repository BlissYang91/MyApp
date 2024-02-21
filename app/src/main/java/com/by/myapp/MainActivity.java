package com.by.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.by.myapp.service.AccessService;
import com.by.myapp.service.BaseService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * {
 *     "HotWords":[
 *         "蓝牙电话",
 *         "火山车娱",
 *         "个人中心"
 *     ],
 *     "UserData":{
 *         "viewCmd::default":{
 *             "activeStatus":"bg",
 *             "data":{
 *                 "hotInfo":{
 *                     "viewCmd":"蓝牙电话火山车娱|个人中心|"
 *                 }
 *             },
 *             "sceneStatus":"default"
 *         }
 *     }
 * }
 */

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private  BaseService instance;
    //    @Inject
    HiltViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        instance = BaseService.getInstance();
//        instance.init(this);
//        String json = "{\"HotWords\":[\"蓝牙电话\",\"个人中心\"],\"UserData\":{\"viewCmd::default\":{\"activeStatus\":\"bg\",\"data\":{\"hotInfo\":{\"viewCmd\":\"蓝牙电话|个人中心|\"}},\"sceneStatus\":\"default\"}}}";
//        String res = analyzeJson("viewCmd", "蓝牙电话|个人中心|测试数据", json).toString();
//        System.out.println("ytf ========res == " + res);

        viewModel = new ViewModelProvider(this).get(HiltViewModel.class);
//        viewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(HiltViewModel.class);
        if (viewModel != null) {
            viewModel.getUiEvent().observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer uiEvent) {
                    Log.d(TAG, "UiEvent onChanged: ytf, ------------------------- UiEvent: " + uiEvent);
                }
            });
        }

    }

    private String analyzeJson(String key, Object value, Object object) {
        try {
            if (object instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) object;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    analyzeJson(key, value, jsonObject);
                }
            } else if (object instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) object;
                Iterator iterator = jsonObject.keys();
                while (iterator.hasNext()) {
                    String jsonKey = iterator.next().toString();
                    Object ob = jsonObject.get(jsonKey);
                    if (ob != null) {
                        if (ob instanceof JSONArray) {
                            analyzeJson(key, value, ob);
                        } else if (ob instanceof JSONObject) {
                            analyzeJson(key, value, ob);
                        } else {
                            if (jsonKey.equals(key)) {
                                jsonObject.put(key, value);
                            }
                            return jsonObject.toString();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (!instance.checkAccessibilityEnabled(getResources().getString(R.string.access_name))) {
//            instance.goAccess();
//        }
    }
}