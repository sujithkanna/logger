package com.hsalf.logger;

public abstract class BaseLog {

    private static final String TAG = "BaseLog";

    public abstract void i(Object msg);

    public abstract void i(String tag, Object msg);

    public abstract void i(String tag, Object msg, boolean detect);

    public abstract void i(String tag, Object msg, Throwable thr);

    public abstract void i(String tag, Object msg, Throwable thr, boolean detect);

    public abstract void d(Object msg);

    public abstract void d(String tag, Object msg);

    public abstract void d(String tag, Object msg, boolean detect);

    public abstract void d(String tag, Object msg, Throwable thr);

    public abstract void d(String tag, Object msg, Throwable thr, boolean detect);

    public abstract void e(Object msg);

    public abstract void e(String tag, Object msg);

    public abstract void e(String tag, Object msg, boolean detect);

    public abstract void e(String tag, Object msg, Throwable thr);

    public abstract void e(String tag, Object msg, Throwable thr, boolean detect);

    public abstract void w(Object msg);

    public abstract void w(String tag, Object msg);

    public abstract void w(String tag, Object msg, boolean detect);

    public abstract void w(String tag, Object msg, Throwable thr);

    public abstract void w(String tag, Object msg, Throwable thr, boolean detect);

    public abstract void v(Object msg);

    public abstract void v(String tag, Object msg);

    public abstract void v(String tag, Object msg, boolean detect);

    public abstract void v(String tag, Object msg, Throwable thr);

    public abstract void v(String tag, Object msg, Throwable thr, boolean detect);

}
