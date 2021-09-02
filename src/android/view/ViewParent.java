package android.view;

public interface ViewParent {
    void requestLayout();
    ViewParent getParent();

    void requestDisallowInterceptTouchEvent(boolean disallowIntercept);
}
