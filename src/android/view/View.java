package android.view;

import android.context.Context;
import android.AttributeSet;

public class View {
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
}
