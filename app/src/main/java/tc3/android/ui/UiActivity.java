package tc3.android.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tc3.android.R;

public class UiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
    }
}