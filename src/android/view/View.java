package android.view;

import android.context.Context;
import android.AttributeSet;
import android.event.KeyEvent;
import android.event.MotionEvent;

public class View implements KeyEvent.Callback {
    protected Context mContext;

    public View(Context context) {
        mContext = context;
    }

    public View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public View(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public View(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context);
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        // onTouchListener가 있으면 TouchListener를 호출하고, 아니면 onTouchEvent를 호출한다.
        boolean result = false;
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnTouchListener != null && li.mOnTouchListener.onTouch(this, event)) {
            result = true;
        }

        if (!result && onTouchEvent(event)) {
            result = true;
        }

        return result;
    }

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    /**
     * KeyEvent
     */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        return false;
    }


    /**
     * Listener들 정의
     * Listener필드들을 ListenerInfo에 하나로 묶어둔다.
     */
    @FunctionalInterface
    public interface OnTouchListener {
        boolean onTouch(View v, MotionEvent event);
    }

    @FunctionalInterface
    public interface OnClickListener {
        void onClick(View v);
    }

    static class ListenerInfo {
        // 이런 리스너들은 ListenerInfo 클래스에 모은다.
        private OnTouchListener mOnTouchListener;

        public OnClickListener mOnClickListener;    // 왜 얘는 public이지?
    }

    ListenerInfo mListenerInfo;

    // 리스너들을 얻을 수 있는 메소드 정적 클래스
    ListenerInfo getListenerInfo() {
        if (mListenerInfo != null)
            return mListenerInfo;

        mListenerInfo = new ListenerInfo();
        return mListenerInfo;
    }

    public void setOnTouchListener(OnTouchListener l) {
        getListenerInfo().mOnTouchListener = l;
    }

    public void setOnClickListener(OnClickListener l) {
        // clickable이 아니면 clickable로 먼저 변경한다.

        getListenerInfo().mOnClickListener = l;
    }

    // ViewParent 관련
    protected ViewParent mParent;

    void assignParent(ViewParent parent) {
        if(mParent == null) {
            mParent = parent;
        } else if(parent == null) {
            mParent = null;
        } else {
            throw new RuntimeException("view " + this + " being added, but" + " it already has a parent");
            // throwException
        }
    }

    public final ViewParent getParent() {
        return mParent;
    }

    public void requestLayout() { }
}
