package android.viewGroup;

import android.AttributeSet;
import android.context.Context;
import android.event.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class ViewGroup extends View implements ViewParent {

    // constructor
    public ViewGroup(Context context) {
        this(context, null);
    }

    public ViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initViewGroup();
        initFromAttributes(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initViewGroup() {

    }

    private void initFromAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    /**
     * onInterceptTouchEvent
     * 자식뷰의 TouchEvent실행을 막고, ViewGroup의 실행이 필요할 때 (Button위치때문에, 스크롤을 할 수 없을 때)
     * onInterceptTouchEvent가 true를 리턴하면 더 이상 하위 뷰에서 TouchEvent가 실행되지 않는다.
     *
     * onInterceptTouchEvent는 ViewGruop의 dispatchTouchEvent가 실행된 후에 실행된다.
     */
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    // ViewGroup에도 LayoutParams 내부 정적 클래스가 존재한다. -> ViewGroup의 width, height정보를 저장
    public static class LayoutParams {
        public static final int MATCH_PARENT = -1;
        public static final int WRAP_CONTENT = -2;

        public int width;
        public int height;

        public LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public LayoutParams(LayoutParams source) {
            this.width = source.width;
            this.height = source.height;
        }

        LayoutParams() {
        }
    }

    // 위 정적 클래스를 상속받는 MarginLayoutParams가 존재한다. -> 해당 ViewGroup의 margin정보를 저장
    public static class MarginLayoutParams extends ViewGroup.LayoutParams {
        public int leftMargin;
        public int topMargin;
        public int rightMargin;
        public int bottomMargin;

        private int startMargin = DEFAULT_MARGIN_RELATIVE;
        private int endMargin = DEFAULT_MARGIN_RELATIVE;

        public static final int DEFAULT_MARGIN_RELATIVE = Integer.MAX_VALUE;

        public MarginLayoutParams(int width, int height) {
            super(width, height);
        }

        public MarginLayoutParams(MarginLayoutParams source) {
            this.width = source.width;
            this.height = source.height;

            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;

            this.startMargin = source.startMargin;
            this.endMargin = source.endMargin;
        }

        public MarginLayoutParams(LayoutParams source) {
            super(source);
        }

        public final void copyMarginsFrom(MarginLayoutParams source) {
            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;
            this.startMargin = source.startMargin;
            this.endMargin = source.endMargin;
        }

        public void setMargins(int left, int top, int right, int bottom) {
            leftMargin = left;
            topMargin = top;
            rightMargin = right;
            bottomMargin = bottom;
        }
    }

    /**
     * ViewParent 관련 구현함수
     */
    protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000;
    protected int mGroupFlags;

    // disallowIntercpet가 true이면 부모View는 자식View의 TouchEvent를 Intercept하지 못한다.
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept == ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0)) {
            // We're already in this state, assume our ancestors are too
            return;
        }

        if (disallowIntercept) {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } else {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        }

        // Pass it up to our parent
        if (mParent != null) {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }
}
