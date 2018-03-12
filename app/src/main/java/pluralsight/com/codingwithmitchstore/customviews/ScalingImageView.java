package pluralsight.com.codingwithmitchstore.customviews;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by User on 3/9/2018.
 */

public class ScalingImageView extends android.support.v7.widget.AppCompatImageView implements
        View.OnTouchListener,
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final String TAG = "ScalingImageView";


    //shared constructing
    Context mContext;
    ScaleGestureDetector mScaleDetector;
    GestureDetector mGestureDetector;
    Matrix mMatrix;
    float[] mMatrixValues;


    public ScalingImageView(Context context) {
        super(context);
        sharedConstructing(context);
    }

    public ScalingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        sharedConstructing(context);
    }

    private void sharedConstructing(Context context) {
        super.setClickable(true);
        mContext = context;
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        mMatrix = new Matrix();
        mMatrixValues = new float[9];
        setImageMatrix(mMatrix);
        setScaleType(ScaleType.MATRIX);

        mGestureDetector = new GestureDetector(context, this);
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

}















