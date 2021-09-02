package android.activity;

import android.context.Context;
import android.event.MotionEvent;

public class Activity extends Context {
    private static final String TAG = "Activity";

    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = -1;
    public static final int RESULT_FIRST_USER = 1;

    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
            // onUserInteraction();
            return true;
        }

        return onTouchEvent(ev);
    }
}
