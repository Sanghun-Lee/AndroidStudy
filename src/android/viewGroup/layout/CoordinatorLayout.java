package android.viewGroup.layout;

import android.AttributeSet;
import android.context.Context;
import android.viewGroup.ViewGroup;

public class CoordinatorLayout extends ViewGroup {

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity = 0;         // Gravity.NO_GRAVITY;
        public int anchorGravity = 0;   // Gravity.NO_GRAVITY;

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(LayoutParams p) {
            super(p);
        }

        public LayoutParams(MarginLayoutParams p) {
            super(p);
        }

        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }
    }
}
