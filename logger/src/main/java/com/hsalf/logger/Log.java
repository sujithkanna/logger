package com.hsalf.logger;

import android.content.Context;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Log {
    private static final String TAG = "Log";

    private static final int detect_INDEX = 6;

    private static Log sLog = new Log();

    private boolean mAutoName = true;

    private LogAlive mLogAlive = new LogAlive(); // Enabled log instance
    private LogEmpty mLogEmpty = new LogEmpty(); // Disabled log instance

    private BaseLog mBaseLog = mLogAlive; // Instance of the log

    private Log() {
    }

    public static boolean isDebuggable(Context context) {
        try {
            final String packageName = context.getPackageName();
            final Class<?> buildConfig = Class.forName(packageName + ".BuildConfig");
            final Field DEBUG = buildConfig.getField("DEBUG");
            DEBUG.setAccessible(true);
            return DEBUG.getBoolean(null);
        } catch (final Throwable t) {
            // ignore
        }
        return false;
    }

    /**
     * Enable/Disable auto name detection
     *
     * @param enable true to enable class and detect name auto detection (which is expensive)
     *               false to disable auto name detection
     *               <p>
     *               Highly recommended not to enable in release mode
     */
    public static void enableAutoNameDetection(boolean enable) {
        synchronized (TAG) {
            android.util.Log.e(TAG, "Debug: " + enable);
            sLog.mAutoName = enable;
        }
    }

    /**
     * Enables all logs
     */
    public static void enable() {
        synchronized (TAG) {
            sLog.mBaseLog = sLog.mLogAlive;
        }
    }

    /**
     * Disables all logs
     */
    public static void disable() {
        synchronized (TAG) {
            sLog.mBaseLog = sLog.mLogEmpty;
        }
    }

    public static void i(String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.i(msg);
        }
    }

    public static void i(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, detect);
        }
    }


    public static void i(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, thr);
        }
    }

    public static void i(String tag, String msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, thr, detect);
        }
    }

    public static void d(String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.d(msg);
        }
    }

    public static void d(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, detect);
        }
    }


    public static void d(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, thr);
        }
    }

    public static void d(String tag, String msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, thr, detect);
        }
    }

    public static void e(String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.e(msg);
        }
    }

    public static void e(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, detect);
        }
    }

    public static void e(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, thr);
        }
    }

    public static void e(String tag, String msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, thr, detect);
        }
    }

    public static void w(String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.w(msg);
        }
    }

    public static void w(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, detect);
        }
    }

    public static void w(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, thr);
        }
    }

    public static void w(String tag, String msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, thr, detect);
        }
    }

    public static void v(String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.v(msg);
        }
    }

    public static void v(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, detect);
        }
    }

    public static void v(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, thr);
        }
    }

    public static void v(String tag, String msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, thr, detect);
        }
    }

    /**
     * Active log which logs
     */
    private static class LogAlive extends BaseLog {
        @Override
        public void i(String msg) {
            i(prepareTag(null, true), msg);
        }

        @Override
        public void i(String tag, String msg) {
            android.util.Log.i(tag, msg);
        }

        @Override
        public void i(String tag, String msg, boolean detect) {
            i(prepareTag(tag, detect), msg);
        }

        @Override
        public void i(String tag, String msg, Throwable thr) {
            android.util.Log.i(tag, msg, thr);
        }

        @Override
        public void i(String tag, String msg, Throwable thr, boolean detect) {
            i(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void d(String msg) {
            d(prepareTag(null, true), msg);
        }

        @Override
        public void d(String tag, String msg) {
            android.util.Log.d(tag, msg);
        }

        @Override
        public void d(String tag, String msg, boolean detect) {
            d(prepareTag(tag, detect), msg);
        }

        @Override
        public void d(String tag, String msg, Throwable thr) {
            android.util.Log.d(tag, msg, thr);
        }

        @Override
        public void d(String tag, String msg, Throwable thr, boolean detect) {
            d(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void e(String msg) {
            e(prepareTag(null, true), msg);
        }

        @Override
        public void e(String tag, String msg) {
            android.util.Log.e(tag, msg);
        }

        @Override
        public void e(String tag, String msg, boolean detect) {
            e(prepareTag(tag, detect), msg);
        }

        @Override
        public void e(String tag, String msg, Throwable thr) {
            android.util.Log.e(tag, msg, thr);
        }

        @Override
        public void e(String tag, String msg, Throwable thr, boolean detect) {
            e(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void w(String msg) {
            w(prepareTag(null, true), msg);
        }

        @Override
        public void w(String tag, String msg) {
            android.util.Log.w(tag, msg);
        }

        @Override
        public void w(String tag, String msg, boolean detect) {
            w(prepareTag(tag, detect), msg);
        }

        @Override
        public void w(String tag, String msg, Throwable thr) {
            android.util.Log.w(tag, msg, thr);
        }

        @Override
        public void w(String tag, String msg, Throwable thr, boolean detect) {
            w(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void v(String msg) {
            v(prepareTag(null, true), msg);
        }

        @Override
        public void v(String tag, String msg) {
            android.util.Log.v(tag, msg);
        }

        @Override
        public void v(String tag, String msg, boolean detect) {
            v(prepareTag(tag, detect), msg);
        }

        @Override
        public void v(String tag, String msg, Throwable thr) {
            android.util.Log.v(tag, msg, thr);
        }

        @Override
        public void v(String tag, String msg, Throwable thr, boolean detect) {
            v(prepareTag(tag, detect), msg, thr);
        }
    }

    /**
     * Empty log to disable logs when needed
     */
    private static class LogEmpty extends BaseLog {

        @Override
        public void i(String msg) {

        }

        @Override
        public void i(String tag, String msg) {

        }

        @Override
        public void i(String tag, String msg, boolean detect) {

        }

        @Override
        public void i(String tag, String msg, Throwable thr) {

        }

        @Override
        public void i(String tag, String msg, Throwable thr, boolean detect) {

        }

        @Override
        public void d(String msg) {

        }

        @Override
        public void d(String tag, String msg) {

        }

        @Override
        public void d(String tag, String msg, boolean detect) {

        }

        @Override
        public void d(String tag, String msg, Throwable thr) {

        }

        @Override
        public void d(String tag, String msg, Throwable thr, boolean detect) {

        }

        @Override
        public void e(String msg) {

        }

        @Override
        public void e(String tag, String msg) {

        }

        @Override
        public void e(String tag, String msg, boolean detect) {

        }

        @Override
        public void e(String tag, String msg, Throwable thr) {

        }

        @Override
        public void e(String tag, String msg, Throwable thr, boolean detect) {

        }

        @Override
        public void w(String msg) {

        }

        @Override
        public void w(String tag, String msg) {

        }

        @Override
        public void w(String tag, String msg, boolean detect) {

        }

        @Override
        public void w(String tag, String msg, Throwable thr) {

        }

        @Override
        public void w(String tag, String msg, Throwable thr, boolean detect) {

        }

        @Override
        public void v(String msg) {

        }

        @Override
        public void v(String tag, String msg) {

        }

        @Override
        public void v(String tag, String msg, boolean detect) {

        }

        @Override
        public void v(String tag, String msg, Throwable thr) {

        }

        @Override
        public void v(String tag, String msg, Throwable thr, boolean detect) {

        }
    }

    /**
     * Gets the detect name where this log has been called from
     *
     * @param tag        is the tag to be printed in the log
     * @param detect true if to return the detect name, false if no detect name required
     * @return
     */
    private static String prepareTag(String tag, boolean detect) {
        if (!detect || !sLog.mAutoName) {
            return tag != null ? tag : "Log";
        }
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        return String.format("%s_%s()_%s", tag != null ? tag :
                        splitClassName(trace[detect_INDEX].getClassName()),
                trace[detect_INDEX].getMethodName(), trace[detect_INDEX].getLineNumber());
    }

    private static String splitClassName(String className) {
        String[] slittedName = className.split(Pattern.quote("."));
        return slittedName[slittedName.length - 1];
    }
}
