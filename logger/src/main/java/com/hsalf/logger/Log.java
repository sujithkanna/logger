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

    public static void i(Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.i(msg);
        }
    }

    public static void i(String tag, Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg);
        }
    }

    public static void i(String tag, Object msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, detect);
        }
    }


    public static void i(String tag, Object msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, thr);
        }
    }

    public static void i(String tag, Object msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, thr, detect);
        }
    }

    public static void d(Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.d(msg);
        }
    }

    public static void d(String tag, Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg);
        }
    }

    public static void d(String tag, Object msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, detect);
        }
    }


    public static void d(String tag, Object msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, thr);
        }
    }

    public static void d(String tag, Object msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, thr, detect);
        }
    }

    public static void e(Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.e(msg);
        }
    }

    public static void e(String tag, Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg);
        }
    }

    public static void e(String tag, Object msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, detect);
        }
    }

    public static void e(String tag, Object msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, thr);
        }
    }

    public static void e(String tag, Object msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, thr, detect);
        }
    }

    public static void w(Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.w(msg);
        }
    }

    public static void w(String tag, Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg);
        }
    }

    public static void w(String tag, Object msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, detect);
        }
    }

    public static void w(String tag, Object msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, thr);
        }
    }

    public static void w(String tag, Object msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, thr, detect);
        }
    }

    public static void v(Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.v(msg);
        }
    }

    public static void v(String tag, Object msg) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg);
        }
    }

    public static void v(String tag, Object msg, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, detect);
        }
    }

    public static void v(String tag, Object msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, thr);
        }
    }

    public static void v(String tag, Object msg, Throwable thr, boolean detect) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, thr, detect);
        }
    }

    /**
     * Active log which logs
     */
    private static class LogAlive extends BaseLog {
        @Override
        public void i(Object msg) {
            i(prepareTag(null, true), msg);
        }

        @Override
        public void i(String tag, Object msg) {
            android.util.Log.i(tag, getMessageString(msg));
        }

        @Override
        public void i(String tag, Object msg, boolean detect) {
            i(prepareTag(tag, detect), msg);
        }

        @Override
        public void i(String tag, Object msg, Throwable thr) {
            android.util.Log.i(tag, getMessageString(msg), thr);
        }

        @Override
        public void i(String tag, Object msg, Throwable thr, boolean detect) {
            i(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void d(Object msg) {
            d(prepareTag(null, true), msg);
        }

        @Override
        public void d(String tag, Object msg) {
            android.util.Log.d(tag, getMessageString(msg));
        }

        @Override
        public void d(String tag, Object msg, boolean detect) {
            d(prepareTag(tag, detect), msg);
        }

        @Override
        public void d(String tag, Object msg, Throwable thr) {
            android.util.Log.d(tag, getMessageString(msg), thr);
        }

        @Override
        public void d(String tag, Object msg, Throwable thr, boolean detect) {
            d(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void e(Object msg) {
            e(prepareTag(null, true), msg);
        }

        @Override
        public void e(String tag, Object msg) {
            android.util.Log.e(tag, getMessageString(msg));
        }

        @Override
        public void e(String tag, Object msg, boolean detect) {
            e(prepareTag(tag, detect), msg);
        }

        @Override
        public void e(String tag, Object msg, Throwable thr) {
            android.util.Log.e(tag, getMessageString(msg), thr);
        }

        @Override
        public void e(String tag, Object msg, Throwable thr, boolean detect) {
            e(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void w(Object msg) {
            w(prepareTag(null, true), msg);
        }

        @Override
        public void w(String tag, Object msg) {
            android.util.Log.w(tag, getMessageString(msg));
        }

        @Override
        public void w(String tag, Object msg, boolean detect) {
            w(prepareTag(tag, detect), msg);
        }

        @Override
        public void w(String tag, Object msg, Throwable thr) {
            android.util.Log.w(tag, getMessageString(msg), thr);
        }

        @Override
        public void w(String tag, Object msg, Throwable thr, boolean detect) {
            w(prepareTag(tag, detect), msg, thr);
        }

        @Override
        public void v(Object msg) {
            v(prepareTag(null, true), msg);
        }

        @Override
        public void v(String tag, Object msg) {
            android.util.Log.v(tag, getMessageString(msg));
        }

        @Override
        public void v(String tag, Object msg, boolean detect) {
            v(prepareTag(tag, detect), msg);
        }

        @Override
        public void v(String tag, Object msg, Throwable thr) {
            android.util.Log.v(tag, getMessageString(msg), thr);
        }

        @Override
        public void v(String tag, Object msg, Throwable thr, boolean detect) {
            v(prepareTag(tag, detect), msg, thr);
        }
    }

    /**
     * Empty log to disable logs when needed
     */
    private static class LogEmpty extends BaseLog {

        @Override
        public void i(Object msg) {

        }

        @Override
        public void i(String tag, Object msg) {

        }

        @Override
        public void i(String tag, Object msg, boolean detect) {

        }

        @Override
        public void i(String tag, Object msg, Throwable thr) {

        }

        @Override
        public void i(String tag, Object msg, Throwable thr, boolean detect) {

        }

        @Override
        public void d(Object msg) {

        }

        @Override
        public void d(String tag, Object msg) {

        }

        @Override
        public void d(String tag, Object msg, boolean detect) {

        }

        @Override
        public void d(String tag, Object msg, Throwable thr) {

        }

        @Override
        public void d(String tag, Object msg, Throwable thr, boolean detect) {

        }

        @Override
        public void e(Object msg) {

        }

        @Override
        public void e(String tag, Object msg) {

        }

        @Override
        public void e(String tag, Object msg, boolean detect) {

        }

        @Override
        public void e(String tag, Object msg, Throwable thr) {

        }

        @Override
        public void e(String tag, Object msg, Throwable thr, boolean detect) {

        }

        @Override
        public void w(Object msg) {

        }

        @Override
        public void w(String tag, Object msg) {

        }

        @Override
        public void w(String tag, Object msg, boolean detect) {

        }

        @Override
        public void w(String tag, Object msg, Throwable thr) {

        }

        @Override
        public void w(String tag, Object msg, Throwable thr, boolean detect) {

        }

        @Override
        public void v(Object msg) {

        }

        @Override
        public void v(String tag, Object msg) {

        }

        @Override
        public void v(String tag, Object msg, boolean detect) {

        }

        @Override
        public void v(String tag, Object msg, Throwable thr) {

        }

        @Override
        public void v(String tag, Object msg, Throwable thr, boolean detect) {

        }
    }

    /**
     * Gets the detect name where this log has been called from
     *
     * @param tag    is the tag to be printed in the log
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

    private static String getMessageString(Object msg) {
        if (msg == null) {
            return "null";
        }
        return msg.toString();
    }
}
