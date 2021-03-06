package com.overface.learningandroid.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.overface.learningandroid.R;

public class SingleListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_list_view);

        initLayout();
    }

    private void initLayout(){
        String[] items = getResources().getStringArray(R.array.arrays_list_item);
        // 단일 체크 레이아웃 어뎁터 설정 android.R.layout.simple_list_item_single_choice
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);
        ListView listview = findViewById(R.id.lv_effects);

        // 단일 선택 설정
        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listview.setAdapter(adapter);
    }
}
