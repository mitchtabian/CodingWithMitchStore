package pluralsight.com.codingwithmitchstore.customviews;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by User on 3/4/2018.
 */

public class MyDragShadowBuilder extends View.DragShadowBuilder{

    private static Drawable shadow;

    public MyDragShadowBuilder(View v, int imageResource) {
        super(v);

        shadow = getView().getContext().getResources().getDrawable(imageResource);
    }


    @Override
    public void onProvideShadowMetrics (Point size, Point touch) {
        int width, height, imageRatio;

        imageRatio = shadow.getIntrinsicHeight() / shadow.getIntrinsicWidth();

        width = getView().getWidth() / 2;

        height = width * imageRatio;

        shadow.setBounds(0, 0, width, height);

        size.set(width, height);

        touch.set(width / 2, height / 2);
    }


    @Override
    public void onDrawShadow(Canvas canvas) {

        shadow.draw(canvas);
    }


}


















