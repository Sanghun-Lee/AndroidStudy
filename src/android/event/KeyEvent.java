package android.event;

public class KeyEvent {
    public static final int KEYCODE_UNKNOWN = 0;
    public static final int KEYCODE_HOME = 3;
    public static final int KEYCODE_BACK = 4;
    public static final int KEYCODE_CALL = 5;

    public static final int KEYCODE_VOLUME_UP = 24;
    public static final int KEYCODE_VOLUME_DOWN = 25;
    public static final int KEYCODE_POWER = 26;

    public interface Callback {
        boolean onKeyDown(int keyCode, KeyEvent event);

        boolean onKeyLongPress(int keyCode, KeyEvent event);

        boolean onKeyUp(int keyCode, KeyEvent event);

        boolean onKeyMultiple(int keyCode, int count, KeyEvent event);
    }
}
