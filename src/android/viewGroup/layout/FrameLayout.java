package android.viewGroup.layout;

import android.AttributeSet;
import android.context.Context;
import android.view.View;
import android.viewGroup.ViewGroup;

import java.util.ArrayList;

public class FrameLayout extends ViewGroup {
    boolean mMeasureAllChildren = false;
    private int mForegroundPaddingLeft = 0;

    public FrameLayout(Context context) {
        this(context, null);
    }

    public FrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public FrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private final ArrayList<View> mMatchParentChildren = new ArrayList<>(1);

    public void setMeasureAllChildren(boolean measureAll) {
        mMeasureAllChildren = measureAll;
    }

    public boolean getMeasureAllChildren() {
        return mMeasureAllChildren;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int UNSPECIFIED_GRAVITY = -1;
        public int gravity = UNSPECIFIED_GRAVITY;

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.gravity = gravity;
        }

        public LayoutParams(LayoutParams source) {
            super(source);

            this.gravity = source.gravity;
        }
    }
}
