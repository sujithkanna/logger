package com.hsalf.logger;

public abstract class BaseLog {

    private static final String TAG = "BaseLog";

    public abstract void i(String tag, String msg);

    public abstract void i(String tag, String msg, boolean method);

    public abstract void i(String tag, String msg, Throwable thr);

    public abstract void i(String tag, String msg, Throwable thr, boolean method);

    public abstract void d(String tag, String msg);

    public abstract void d(String tag, String msg, boolean method);

    public abstract void d(String tag, String msg, Throwable thr);

    public abstract void d(String tag, String msg, Throwable thr, boolean method);

    public abstract void e(String tag, String msg);

    public abstract void e(String tag, String msg, boolean method);

    public abstract void e(String tag, String msg, Throwable thr);

    public abstract void e(String tag, String msg, Throwable thr, boolean method);

    public abstract void w(String tag, String msg);

    public abstract void w(String tag, String msg, boolean method);

    public abstract void w(String tag, String msg, Throwable thr);

    public abstract void w(String tag, String msg, Throwable thr, boolean method);

    public abstract void v(String tag, String msg);

    public abstract void v(String tag, String msg, boolean method);

    public abstract void v(String tag, String msg, Throwable thr);

    public abstract void v(String tag, String msg, Throwable thr, boolean method);

}
