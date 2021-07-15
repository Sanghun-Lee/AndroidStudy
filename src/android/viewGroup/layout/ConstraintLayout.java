package android.viewGroup.layout;

import android.AttributeSet;
import android.context.Context;
import android.viewGroup.ViewGroup;

public class ConstraintLayout extends ViewGroup {
    public static final String VERSION = "ConstraintLayout-1.1.3";
    private static final String TAG = "ConstraintLayout";

    private int mMinWidth = 0;
    private int mMinHeight = 0;
    private int mMaxWidth = 2147483647;
    private int mMaxHeight = 2147483647;

    public void setMinWidth(int value) {
        if (value != this.mMinWidth) {
            this.mMinWidth = value;
            this.requestLayout();
        }
    }

    public void setMinHeight(int value) {
        if (value != this.mMinHeight) {
            this.mMinHeight = value;
            this.requestLayout();
        }
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxHeight(int value) {
        if (value != this.mMaxHeight) {
            this.mMaxHeight = value;
            this.requestLayout();
        }
    }

    public void setMaxWidth(int value) {
        if (value != this.mMaxWidth) {
            this.mMaxWidth = value;
            this.requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public void requestLayout() {
        // TODO Something
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.init((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(attrs);
    }

    public ConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(attrs);
    }

    private void init(AttributeSet attrs) {

    }


    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int MATCH_CONSTRAINT = 0;
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;

        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;

        public LayoutParams(ConstraintLayout.LayoutParams source) {
            super(source);
            this.leftToLeft = source.leftToLeft;
            this.leftToRight = source.leftToRight;
            this.rightToLeft = source.rightToLeft;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

    }
}
