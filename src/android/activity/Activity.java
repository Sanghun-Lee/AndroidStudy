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

    /**
     * TouchEvent
     * 기본적으로 TouchEvent는
     * Activity의 dispatchTouchEvent ->
     * ViewGroup의 dispatchTouchEvent ->
     * View의 dispatchTouchEvent ->
     * View의 onTouchEvent ->
     * ViewGroup의 onTouchEvent ->
     * Activity의 onTouchEvent
     * 순으로 실행된다.
     * 
     * 하지만 ACTION_DOWN시에, View, ViewGroup, Activity에서 onTouchEvent를 true를 리턴하면서 소비하면
     * ACTION_UP까지 하위 뷰에 onTouchEvent가 실행되지 않는다
     *
     * ex. ViewGroup에서 onTouchEvent를 소비한 경우
     * Activity의 dispatchTouchEvent ->
     * ViewGroup의 dispatchTouchEvent ->
     * View의 dispatchTouchEvent ->
     * View의 onTouchEvent ->
     * ViewGroup의 onTouchEvent
     * -------------- ACTION_MOVE -------------
     * Activity의 dispatchTouchEvent ->
     * ViewGroup의 dispatchTouchEvent ->
     * ViewGroup의 onTouchEvent ....
     */
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
            // onUserInteraction();
            return true;
        }

        return onTouchEvent(ev);
    }
}
