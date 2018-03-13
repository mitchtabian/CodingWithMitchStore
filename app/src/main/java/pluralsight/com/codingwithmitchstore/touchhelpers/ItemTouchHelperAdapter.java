package pluralsight.com.codingwithmitchstore.touchhelpers;

/**
 * Created by User on 3/5/2018.
 */

public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemSwiped(int position);
}
