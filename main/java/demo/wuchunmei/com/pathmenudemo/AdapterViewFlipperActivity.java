package demo.wuchunmei.com.pathmenudemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by wuchunmei on 6/27/17.
 */
public class AdapterViewFlipperActivity extends AppCompatActivity {
    int[] imageIds = new int[]{R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a2,R.drawable.a3,R.drawable.a4};
    AdapterViewFlipper adapterViewFlipper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper_layout);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);
        MyAdapter adapter = new MyAdapter();
        adapterViewFlipper.setAdapter(adapter);
    }

    private  class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(AdapterViewFlipperActivity.this);
            imageView.setImageResource(imageIds[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return imageView;
        }
    }
    public void prev(View source) {
        //显示上一个组件
        adapterViewFlipper.showPrevious();
        //停止自动播放
        adapterViewFlipper.stopFlipping();
    }

    public void next(View source) {
        //显示下一个组件
        adapterViewFlipper.setInAnimation(this, R.animator.flipper_in);
        adapterViewFlipper.setOutAnimation(this, R.animator.flipper_out);
        adapterViewFlipper.showNext();
        adapterViewFlipper.stopFlipping();
    }

    public void auto(View source) {
        //开始自动播放
        adapterViewFlipper.setInAnimation(this, R.animator.flipper_in);
        adapterViewFlipper.setOutAnimation(this, R.animator.flipper_out);
        adapterViewFlipper.startFlipping();
    }
}
