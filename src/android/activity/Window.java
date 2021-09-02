package android.activity;

import android.event.KeyEvent;
import android.event.MotionEvent;

public abstract class Window {
    public interface Callback {
        boolean dispatchKeyEvent(KeyEvent event);
        boolean dispatchTouchEvent(MotionEvent event);
    }
}
