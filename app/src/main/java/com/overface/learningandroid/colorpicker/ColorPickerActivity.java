package com.overface.learningandroid.colorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.overface.learningandroid.BuildConfig;
import com.overface.learningandroid.R;

public class ColorPickerActivity extends AppCompatActivity implements View.OnClickListener, ColorPickerDialogListener {

    private TextView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        initLayout();
    }

    private void initLayout() {
        mView = findViewById(R.id.tv_color);

        Button button = findViewById(R.id.btn_color_picker1);
        button.setOnClickListener(this);
        button = findViewById(R.id.btn_color_picker2);
        button.setOnClickListener(this);
        button = findViewById(R.id.btn_color_picker3);
        button.setOnClickListener(this);
    }

    // Give your color picker dialog unique IDs if you have multiple dialogs.
    /**
     * 생성이 될 색상 선택 다이어로그에 고유 ID 관리를 위함
     */
    private static final int DIALOG_DEFAULT_ID = 0;
    private static final int DIALOG_PRESET_ID = 1;

    @Override
    public void onClick(View v) {
        final int id = v.getId();

        switch (id) {
            case R.id.btn_color_picker1:
                ColorPickerDialog.newBuilder()
                        .setDialogType(ColorPickerDialog.TYPE_CUSTOM)
                        .setAllowPresets(false)
                        .setDialogId(DIALOG_DEFAULT_ID)
                        .setColor(Color.BLACK)
                        .setShowAlphaSlider(true)
                        .show(this);
                break;

            case R.id.btn_color_picker2:
                ColorPickerDialog.newBuilder()
                        .setDialogType(ColorPickerDialog.TYPE_PRESETS)
                        .setAllowPresets(false)
                        .setDialogId(DIALOG_PRESET_ID)
                        .setColor(Color.BLACK)
                        .setShowAlphaSlider(false)
                        .show(this);
                break;

            case R.id.btn_color_picker3:
                ColorPickerDialog.newBuilder()
                        .setDialogType(ColorPickerDialog.TYPE_PRESETS)
                        .setAllowPresets(false)
                        .setDialogId(DIALOG_PRESET_ID)
                        .setColor(Color.BLACK)
                        .setShowAlphaSlider(true)
                        .show(this);
                break;

            default:
                break;
        }

    }

    /**
     * @brief : Color Picker 대화상자에서 선택된 색상을 콜백으로 알려주는 메소드
     * @param dialogId : Color Picker 대화상자에 고유 ID
     * @param color : Color Picker 대화상자에서 선택 된 색상
     */
    @Override
    public void onColorSelected(int dialogId, final int color) {

        final int invertColor = ~color;
        final String hexColor = String.format("%X", color);
        String hexInvertColor = String.format("%X", invertColor);
        if (BuildConfig.DEBUG) {
            Toast.makeText(this, "id " + dialogId + " c: " + hexColor + " i:" + hexInvertColor, Toast.LENGTH_SHORT).show();
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mView.setBackgroundColor(color);
                mView.setText(hexColor);
            }
        });
    }

    /**
     * @brief : Color Picker dismiss 호출되는 리스너
     * @param dialogId : 종료된 대화상자 고유 아이디
     */
    @Override
    public void onDialogDismissed(int dialogId) {

    }
}
