package android.viewGroup.layout;

import android.AttributeSet;
import android.context.Context;
import android.viewGroup.ViewGroup;

public class LinearLayout extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    public LinearLayout(Context context) {
        this(context, null);
    }

    public LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public LinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private boolean mBaselineAligned = true;
    private int mBaselineAlignedChildIndex = -1;

    public void setBaselineAligned(boolean baselineAligned) {
        mBaselineAligned = baselineAligned;
    }

    public boolean isBaselineAligned() {
        return mBaselineAligned;
    }

    public void setBaselineAlignedChildIndex(int baselineAlignedChildIndex) {
        mBaselineAlignedChildIndex = baselineAlignedChildIndex;
    }

    public int getBaselineAlignedChildIndex() {
        return mBaselineAlignedChildIndex;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int width, int height) {
            super(width, height);
            weight = 0;
        }

        public LayoutParams(int width, int height, float weight) {
            super(width, height);
            this.weight = weight;
        }

        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);   // MarginLayoutParams
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(LayoutParams source) {
            super(source);

            this.weight = source.weight;
            this.gravity = source.gravity;
        }

        public float weight;
        public int gravity = -1;
    }
}
