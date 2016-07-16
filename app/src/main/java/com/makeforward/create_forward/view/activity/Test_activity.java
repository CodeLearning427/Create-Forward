package com.makeforward.create_forward.view.activity;


import patrickwoodburn.com.kidsreader.R;

public class Test_activity extends BaseActivity{
    @Override
    String provideHeaderTitle() {
        return "Test Activity!!!!!";
    }

    @Override
    int getContentId() {
        return R.layout.test_layout;
    }
}
