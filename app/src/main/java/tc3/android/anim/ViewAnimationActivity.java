package tc3.android.anim;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tc3.android.R;

/**
 * 补间动画
 */
public class ViewAnimationActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_tweem);// R.anim.引用补间动画
        imageView.startAnimation(animation);//View应用动画
    }
}
