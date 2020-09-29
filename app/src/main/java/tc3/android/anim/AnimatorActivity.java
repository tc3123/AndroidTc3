package tc3.android.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tc3.android.R;

public class AnimatorActivity extends AppCompatActivity {

    @BindView(R.id.tvTest)
    TextView tvTest;
    @BindView(R.id.btnStart1)
    Button btnStart1;
    @BindView(R.id.btnStart2)
    Button btnStart2;
    @BindView(R.id.btnStart3)
    Button btnStart3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnStart2, R.id.btnStart3, R.id.btnStart1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnStart1:
                ValueAnimator animation = ValueAnimator.ofFloat(0f, 100f);
                animation.setDuration(1000);
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                        // You can use the animated value in a property that uses the
                        // same type as the animation. In this case, you can use the
                        // float value in the translationX property.
                        float animatedValue = (float) updatedAnimation.getAnimatedValue();
                        tvTest.setTranslationX(animatedValue);
                    }
                });
                animation.start();
                break;
            case R.id.btnStart2:
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest, "translationX", 100f);
                objectAnimator.setDuration(1000);
                objectAnimator.start();
                break;
            case R.id.btnStart3:
                break;
        }
    }
}