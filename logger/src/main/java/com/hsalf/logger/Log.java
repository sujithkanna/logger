package com.hsalf.logger;

public class Log {
    private static final String TAG = "Log";

    private static final int METHOD_INDEX = 6;

    private static Log sLog = new Log();

    private boolean mDisableOnRelease = false;

    private LogAlive mLogAlive = new LogAlive(); // Enabled log instance
    private LogEmpty mLogEmpty = new LogEmpty(); // Disabled log instance

    private BaseLog mBaseLog = mLogAlive; // Instance of the log

    private Log() {
    }

    /**
     * Disables the logs on release build
     *
     * @param disable true if the logs has to be disabled in release build
     *                false to enable logs even in release build
     *                If disabled, then it cant be enabled by ({@link #enable()})
     */
    public static void disableOnRelease(boolean disable) {
        synchronized (TAG) {
            sLog.mDisableOnRelease = disable;
        }
        if (!BuildConfig.DEBUG && disable) {
            disable();
        } else {
            enable();
        }
    }

    /**
     * Enables all logs
     */
    public static void enable() {
        synchronized (TAG) {
            if (sLog.mDisableOnRelease) {
                return;
            }
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

    public static void i(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, boolean methodNameNeeded) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, methodNameNeeded);
        }
    }


    public static void i(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, thr);
        }
    }

    public static void i(String tag, String msg, Throwable thr, boolean method) {
        synchronized (TAG) {
            sLog.mBaseLog.i(tag, msg, thr, method);
        }
    }

    public static void d(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, boolean methodNameNeeded) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, methodNameNeeded);
        }
    }


    public static void d(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, thr);
        }
    }

    public static void d(String tag, String msg, Throwable thr, boolean method) {
        synchronized (TAG) {
            sLog.mBaseLog.d(tag, msg, thr, method);
        }
    }

    public static void e(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, boolean methodNameNeeded) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, methodNameNeeded);
        }
    }

    public static void e(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, thr);
        }
    }

    public static void e(String tag, String msg, Throwable thr, boolean method) {
        synchronized (TAG) {
            sLog.mBaseLog.e(tag, msg, thr, method);
        }
    }

    public static void w(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, boolean methodNameNeeded) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, methodNameNeeded);
        }
    }

    public static void w(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, thr);
        }
    }

    public static void w(String tag, String msg, Throwable thr, boolean method) {
        synchronized (TAG) {
            sLog.mBaseLog.w(tag, msg, thr, method);
        }
    }

    public static void v(String tag, String msg) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, boolean method) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, method);
        }
    }

    public static void v(String tag, String msg, Throwable thr) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, thr);
        }
    }

    public static void v(String tag, String msg, Throwable thr, boolean method) {
        synchronized (TAG) {
            sLog.mBaseLog.v(tag, msg, thr, method);
        }
    }

    /**
     * Active log which logs
     */
    private static class LogAlive extends BaseLog {
        public void i(String tag, String msg) {
            android.util.Log.i(tag, msg);
        }

        @Override
        public void i(String tag, String msg, boolean method) {
            i(tag + methodName(method), msg);
        }

        @Override
        public void i(String tag, String msg, Throwable thr) {
            android.util.Log.i(tag, msg, thr);
        }

        @Override
        public void i(String tag, String msg, Throwable thr, boolean method) {
            i(tag + methodName(method), msg, thr);
        }

        public void d(String tag, String msg) {
            android.util.Log.d(tag, msg);
        }

        @Override
        public void d(String tag, String msg, boolean method) {
            d(tag + methodName(method), msg);
        }

        @Override
        public void d(String tag, String msg, Throwable thr) {
            android.util.Log.d(tag, msg, thr);
        }

        @Override
        public void d(String tag, String msg, Throwable thr, boolean method) {
            d(tag + methodName(method), msg, thr);
        }

        public void e(String tag, String msg) {
            android.util.Log.e(tag, msg);
        }

        @Override
        public void e(String tag, String msg, boolean method) {
            e(tag + methodName(method), msg);
        }

        @Override
        public void e(String tag, String msg, Throwable thr) {
            android.util.Log.e(tag, msg, thr);
        }

        @Override
        public void e(String tag, String msg, Throwable thr, boolean method) {
            e(tag + methodName(method), msg, thr);
        }

        public void w(String tag, String msg) {
            android.util.Log.w(tag, msg);
        }

        @Override
        public void w(String tag, String msg, boolean method) {
            w(tag + methodName(method), msg);
        }

        @Override
        public void w(String tag, String msg, Throwable thr) {
            android.util.Log.w(tag, msg, thr);
        }

        @Override
        public void w(String tag, String msg, Throwable thr, boolean method) {
            w(tag + methodName(method), msg, thr);
        }

        @Override
        public void v(String tag, String msg) {
            android.util.Log.v(tag, msg);
        }

        @Override
        public void v(String tag, String msg, boolean method) {
            v(tag + methodName(method), msg);
        }

        @Override
        public void v(String tag, String msg, Throwable thr) {
            android.util.Log.v(tag, msg, thr);
        }

        @Override
        public void v(String tag, String msg, Throwable thr, boolean method) {
            v(tag + methodName(method), msg, thr);
        }
    }

    /**
     * Empty log to disable logs when needed
     */
    private static class LogEmpty extends BaseLog {

        @Override
        public void i(String tag, String msg) {

        }

        @Override
        public void i(String tag, String msg, boolean method) {

        }

        @Override
        public void i(String tag, String msg, Throwable thr) {

        }

        @Override
        public void i(String tag, String msg, Throwable thr, boolean method) {

        }

        @Override
        public void d(String tag, String msg) {

        }

        @Override
        public void d(String tag, String msg, boolean method) {

        }

        @Override
        public void d(String tag, String msg, Throwable thr) {

        }

        @Override
        public void d(String tag, String msg, Throwable thr, boolean method) {

        }

        @Override
        public void e(String tag, String msg) {

        }

        @Override
        public void e(String tag, String msg, boolean method) {

        }

        @Override
        public void e(String tag, String msg, Throwable thr) {

        }

        @Override
        public void e(String tag, String msg, Throwable thr, boolean method) {

        }

        @Override
        public void w(String tag, String msg) {

        }

        @Override
        public void w(String tag, String msg, boolean method) {

        }

        @Override
        public void w(String tag, String msg, Throwable thr) {

        }

        @Override
        public void w(String tag, String msg, Throwable thr, boolean method) {

        }

        @Override
        public void v(String tag, String msg) {

        }

        @Override
        public void v(String tag, String msg, boolean method) {

        }

        @Override
        public void v(String tag, String msg, Throwable thr) {

        }

        @Override
        public void v(String tag, String msg, Throwable thr, boolean method) {

        }
    }

    /**
     * Gets the method name where this log has been called from
     *
     * @param nameNeeded true if to return the method name, false if no method name required
     * @return
     */
    private static String methodName(boolean nameNeeded) {
        if (!nameNeeded) {
            return "";
        }
        return String.format("_%s()",
                Thread.currentThread().getStackTrace()[METHOD_INDEX].getMethodName());
    }
}
