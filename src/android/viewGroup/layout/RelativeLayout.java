package android.viewGroup.layout;

import android.AttributeSet;
import android.context.Context;
import android.viewGroup.ViewGroup;

public class RelativeLayout extends ViewGroup {
    private int mGravity;
    private int mIgnoreGravity;

    private static final int TRUE = -1;
    private static final int DEFAULT_WIDTH = 0x00010000;
    private static final int VERB_COUNT = 22;

    public void setIgnoreGravity(int viewId) {
        mIgnoreGravity = viewId;
    }

    public int getIgnoreGravity() {
        return mIgnoreGravity;
    }

    public int getGravity() {
        return mGravity;
    }

    public void setGravity(int gravity) {
        if (mGravity != gravity) {

        }

        mGravity = gravity;
    }

    public RelativeLayout(Context context) {
        this(context, null);
    }

    public RelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initFromAttributes(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initFromAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private int[] mRules = new int[VERB_COUNT];
        private int[] mInitialRules = new int[VERB_COUNT];
        private boolean mRulesChanged = false;

        private int mLeft;
        private int mTop;
        private int mRight;
        private int mBottom;

        public LayoutParams(int w, int h) {
            super(w, h);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(LayoutParams source) {
            super(source);
        }

        public void addRule(int verb, int subject) {
            // if(....) { }

            mRules[verb] = subject;
            mInitialRules[verb] = subject;
            mRulesChanged = true;
        }

        public void addRule(int verb) {
            addRule(verb, TRUE);
        }

        public void removeRule(int verb) {
            addRule(verb, 0);
        }

        public int getRule(int verb) {
            return mRules[verb];
        }

        public int[] getRules() {
            return mRules;
        }
    }
}
