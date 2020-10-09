package tc3.android.component;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tc3.android.R;
import tc3.android.main.MainActivity;


public class IntentActivity extends AppCompatActivity {


    @BindView(R.id.btnPending)
    Button btnPending;

    @BindView(R.id.btnIntent)
    Button btnIntent;
    @BindView(R.id.btnService)
    Button btnService;
    @BindView(R.id.btnBroadcast)
    Button btnBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        ButterKnife.bind(this);
    }



    @OnClick({R.id.btnService, R.id.btnBroadcast,R.id.btnPending, R.id.btnIntent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnIntent:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"searchString");
                startActivity(intent);
                break;
            case R.id.btnPending:
                break;
            case R.id.btnService:
                startService( new Intent(this, MainActivity.class));
                break;
            case R.id.btnBroadcast:
                break;
        }
    }
}
