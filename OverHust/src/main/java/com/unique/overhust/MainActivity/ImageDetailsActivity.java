package com.unique.overhust.MainActivity;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.unique.overhust.MapUtils.ZoomImageView;
import com.unique.overhust.R;

public class ImageDetailsActivity extends Activity {
    /**
     * 自定义的ImageView控制，可对图片进行多点触控缩放和拖动
     */
    private ZoomImageView zoomImageView;

    /**
     * 待展示的图片
     */
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        zoomImageView = (ZoomImageView) findViewById(R.id.zoom_image_view);
        // 取出图片路径，并解析成Bitmap对象，然后在ZoomImageView中显示
        String imagePath = getIntent().getStringExtra("image_path");
        bitmap = BitmapFactory.decodeFile(imagePath);
        zoomImageView.setImageBitmap(bitmap);

//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.image_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_image_details, container, false);
            return rootView;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 记得将Bitmap对象回收掉
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

}
