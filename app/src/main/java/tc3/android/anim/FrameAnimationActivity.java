package tc3.android.anim;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tc3.android.R;

public class FrameAnimationActivity extends AppCompatActivity {

    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragme_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void onViewClicked() {
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        image.setBackgroundResource(R.drawable.anim_frame);
        Drawable bg = image.getBackground();
        if (bg instanceof Animatable) {
            ((Animatable)bg).start();
        }
    }
}
