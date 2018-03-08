package pluralsight.com.codingwithmitchstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import pluralsight.com.codingwithmitchstore.models.Product;
import pluralsight.com.codingwithmitchstore.resources.Products;
import pluralsight.com.codingwithmitchstore.util.CartManger;


/**
 * Created by User on 3/3/2018.
 */

public class ViewProductActivity extends AppCompatActivity implements
        View.OnTouchListener,
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private static final String TAG = "ViewProductActivity";

    //widgets
    private ViewPager mProductContainer;
    private TabLayout mTabLayout;

    //vars
    private Product mProduct;
    private ProductPagerAdapter mPagerAdapter;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);
        mProductContainer = findViewById(R.id.product_container);
        mTabLayout = findViewById(R.id.tab_layout);


        mProductContainer.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this, this);


        getIncomingIntent();
        initPagerAdapter();
    }

    private void getIncomingIntent(){
        Intent intent = getIntent();
        if(intent.hasExtra(getString(R.string.intent_product))){
            mProduct = intent.getParcelableExtra(getString(R.string.intent_product));
        }
    }

    private void initPagerAdapter(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        Products products = new Products();
        Product[] selectedProducts = products.PRODUCT_MAP.get(mProduct.getType());
        for(Product product: selectedProducts){
            Bundle bundle = new Bundle();
            bundle.putParcelable(getString(R.string.intent_product), product);
            ViewProductFragment viewProductFragment = new ViewProductFragment();
            viewProductFragment.setArguments(bundle);
            fragments.add(viewProductFragment);
        }
        mPagerAdapter = new ProductPagerAdapter(getSupportFragmentManager(), fragments);
        mProductContainer.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mProductContainer, true);
    }


    /*
        OnTouch
     */

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(view.getId() == R.id.product_container){
            mGestureDetector.onTouchEvent(motionEvent);
        }

//        int action = motionEvent.getAction();
//
//        switch(action) {
//            case (MotionEvent.ACTION_DOWN):
//                Log.d(TAG, "Action was DOWN");
//                return false;
//            case (MotionEvent.ACTION_MOVE):
//                Log.d(TAG, "Action was MOVE");
//                return false;
//            case (MotionEvent.ACTION_UP):
//                Log.d(TAG, "Action was UP");
//                return false;
//            case (MotionEvent.ACTION_CANCEL):
//                Log.d(TAG, "Action was CANCEL");
//                return false;
//            case (MotionEvent.ACTION_OUTSIDE):
//                Log.d(TAG, "Movement occurred outside bounds " +
//                        "of current screen element");
//                return false;
//        }

        return false;
    }

    /*
        GestureDetector
     */

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.d(TAG, "onDown: called");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.d(TAG, "onShowPress: called.");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.d(TAG, "onSingleTapUp: called.");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent,
                            MotionEvent motionEvent1,
                            float v, float v1) {
        Log.d(TAG, "onScroll: called.");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.d(TAG, "onLongPress: called.");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent,
                           MotionEvent motionEvent1,
                           float v, float v1) {
        Log.d(TAG, "onFling: called.");
        return false;
    }

    /*
        DoubleTap
     */

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.d(TAG, "onSingleTapConfirmed: called.");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTap: called.");

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTapEvent: called.");
        return false;
    }
}




























