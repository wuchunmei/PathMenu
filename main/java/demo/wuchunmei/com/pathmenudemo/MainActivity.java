package demo.wuchunmei.com.pathmenudemo;

import android.app.Activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ImageView mIvIcon1;
    private ImageView mIvIcon2;
    private ImageView mIvBtn;
    private boolean mIsOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        setContentView(R.layout.activity_main);
        mIvIcon1 = (ImageView) findViewById(R.id.iv_icon3);
        mIvIcon2 = (ImageView) findViewById(R.id.iv_icon4);
        mIvBtn = (ImageView) findViewById(R.id.iv_icon6);
        mIvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsOpen) {
                    showIcon();
                    mIsOpen = false;
                } else {
                    closeIcon();
                    mIsOpen = true;
                }
            }
        });
    }


    /**
     * 动画实现，因为都有角度，所有，要有三角函数计算
     * 使图标位移距离相等，实现扇形效果
     */
     private void showIcon() {
        //设置动画时间
        int duration = 600;
        //动画距离,屏幕宽度的30%
        float distance = getScreenWidth()*0.3f;
        //相邻ImageView运动角度式22.5度
//        float angle1 = (float)(22.5f*Math.PI/180);
        float angle2 = (float)(135f*Math.PI/180);
        float angle3 = (float)(45.5f*Math.PI/180);

         //icon1
//         PropertyValuesHolder p31 = PropertyValuesHolder.ofFloat("TranslationX", 0f, (float) (distance * Math.cos(angle2)));
//         PropertyValuesHolder p32 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -(float) (distance * Math.sin(angle2)));
//         //icon2
//         PropertyValuesHolder p41 = PropertyValuesHolder.ofFloat("TranslationX", 0f, (float) (distance * Math.cos(angle3)));
//         PropertyValuesHolder p42 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -(float) (distance * Math.sin(angle3)));
//         PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha",0f,1f);
//         PropertyValuesHolder rota = PropertyValuesHolder.ofFloat("rotation", 0f, 45f);
//         PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.4f);
//         PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.4f);
//         ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon1, alpha, p31, p32);
//         ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon2, alpha, p41, p42);
//         ObjectAnimator animator6 = ObjectAnimator.ofPropertyValuesHolder(mIvBtn, rota, scaleX, scaleY);
//         AnimatorSet animatorSet = new AnimatorSet();
//         animatorSet.setDuration(duration);
//         animatorSet.setInterpolator(getInterpolator(0.2f, 1f, 0.2f, 1f));
//         animatorSet.playTogether(animator6, animator3, animator4);
//         animatorSet.start();
         Interpolator interpolator = getInterpolator(0.2f, 1f, 0.2f, 1f);
         float translationX_icon1 = (float) (distance * Math.cos(angle2));
         float translationY_icon1 = -(float) (distance * Math.sin(angle2));
         float translationX_icon2 = (float) (distance * Math.cos(angle3));
         float translationY_icon2 = -(float) (distance * Math.sin(angle3));
         mIvBtn.animate().rotation(45f).scaleX(0.4f).scaleY(0.4f).setDuration(duration).setInterpolator(interpolator);
         mIvIcon1.animate().alpha(1).translationX(translationX_icon1).translationY(translationY_icon1)
                 .setDuration(duration).setInterpolator(interpolator);
         mIvIcon2.animate().alpha(1).translationX(translationX_icon2).translationY(translationY_icon2)
                 .setDuration(duration).setInterpolator(interpolator);
    }


    private void closeIcon() {

        //设置动画时间
        int duration = 600;
        //动画距离,屏幕宽度的60%
        float distance = getScreenWidth()*0.3f;
        //相邻ImageView运动角度式22.5度
//        float angle1 = (float)(22.5f*Math.PI/180);
        float angle2 = (float)(135f*Math.PI/180);
        float angle3 = (float)(45.5f*Math.PI/180);

        //icon1
//        PropertyValuesHolder p31 = PropertyValuesHolder.ofFloat("TranslationX", (float) (distance * Math.cos(angle2)),0f);
//        PropertyValuesHolder p32 = PropertyValuesHolder.ofFloat("TranslationY",-(float) (distance * Math.sin(angle2)), 0f);
//        //icon2
//        PropertyValuesHolder p41 = PropertyValuesHolder.ofFloat("TranslationX",(float) (distance * Math.cos(angle3)), 0f);
//        PropertyValuesHolder p42 = PropertyValuesHolder.ofFloat("TranslationY",  -(float) (distance * Math.sin(angle3)),0f);
//        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha",1f,0f);
//        PropertyValuesHolder rota = PropertyValuesHolder.ofFloat("rotation",45f, 0f);
//        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX",0.4f, 1f);
//        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.4f,1f);
//        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon1, alpha, p31, p32);
//        ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon2, alpha, p41, p42);
//        ObjectAnimator animator6 = ObjectAnimator.ofPropertyValuesHolder(mIvBtn, rota, scaleX, scaleY);
//
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.setDuration(duration);
//        animatorSet.setInterpolator(getInterpolator(0.33f,0f,0.12f,1f));
//        animatorSet.playTogether(animator6,animator3,animator4);
//        animatorSet.start();

        Interpolator interpolator = getInterpolator(0.2f, 1f, 0.2f, 1f);
        mIvBtn.animate().rotation(0f).scaleX(1f).scaleY(1f).setDuration(duration).setInterpolator(interpolator);
        mIvIcon1.animate().alpha(0).translationX(0).translationY(0).setDuration(duration).setInterpolator(interpolator);
        mIvIcon2.animate().alpha(0).translationX(0).translationY(0).setDuration(duration).setInterpolator(interpolator);
    }

    /**
     * 竖屏时获取屏幕宽度，横屏时，获取高度
     * @return
     */
    public int getScreenWidth(){
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int x = outMetrics.widthPixels;
        int y = outMetrics.heightPixels;
        return x>y?y:x;
    }

    /**
     * 自定义动画差值器
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Interpolator getInterpolator(float x1, float x2, float y1, float y2) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            return new PathInterpolator(x1, x2, y1, y2);
        } else {
            return new LinearInterpolator();
        }
    }
}
