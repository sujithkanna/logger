# Logger
A simple log helper which helps you to log in a whole different level
	- You can enable and disable logs
	- Can print method names when necessary
##Import
```java
import com.hsalf.logger.Log;
```
import the log from this package instead of default log.
## Basics
Prints the message like the android default log does.
	-``` Log.e(...);``` - Error
	-``` Log.v(...);``` - Verbose
	-``` Log.d(...);``` - Debug
	-``` Log.i(...);``` - Info
	-``` Log.w(...);``` - Warning
##Logging
```java
Log.i(TAG, "Hello log");
```
## Log with throwable
```java
try {
	// Your code which might throw error
} catch (Exception ex) {
	Log.e(TAG, "Got an internal error", ex)
}
```
Like the default android log you can log messages with throwables.
## Features
Now you can print logs with auto tags which is class and method names and the line number.
if you are calling the log from your MainActivity's onCreate

```java
private static final String TAG = "MainActivity";
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.e(TAG, "test hello log", true);
}
```
This will print like
```groovy
E/MainActivity_onCreate()_16: test hello log
```

Here the "MainActivity" is the tag you gave, "onCreate()" is the method where you called the log from, and "16" is the line numer.

The auto naming method is little bit expensive, so it is highly recommended to use this only in debug mode. But is is very simple to enable/disable auto naming.
##Auto Naming
####Create an application class for your application
```java
public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    private static MyApplication sMyApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApplication = this;
        boolean debug = Log.isDebuggable(this);
        Log.enableAutoNameDetection(debug); // Highly recommended
        This enables the auto naming only in debug mode.
    }

    public static MyApplication getInstance() {
        return sMyApplication;
    }
}
```
#### mention it in your manifest's application tag
```xml
<application
        android:name=".MyApplication" // Your application class here
        ...>
		// Your activities, receivers and services
</application>
```

#### Log (Auto naming)
if you call log from your main activity like this

Note: *if enableAutoNameDetection() is set to true*
```java
Log.v("My message");
```
it will print the log as
```groovy
V/MainActivity_myMethod()_22: My message
```
Here the "MainActivity" is the class name and "onCreate()" is the method where you called the log from, and 22" is the line numer.

Note: *if enableAutoNameDetection() is set to false*
```java
Log.v("My message");
```
it will print the log as
```groovy
V/Log: My message
```
Since auto name detection is disabled, it wont auto detect the class name, so the tag by default set to "Log" instead of class name. That is why giving the tag is highly recommended.

```java
Log.v("MainActivity", "My message");
```
Now we have given the tag name manually, So even if the auto name detection is disabled, the log will be printed as
```groovy
V/MainActivity: My message
```
Now you may need auto method naming in release build also.
So here is a way to use auto naming which wont affect app performance on release mode.

Note: *For the following procedures you should not set Log.enableAutoNameDetection() to false, by default it is true*

Create a boolean member variable in your applcation class as "debuggable;

```java
private static MyApplication sMyApplication;

private boolean debuggable;
@Override
public void onCreate() {
    super.onCreate();
    sMyApplication = this;
    debuggable = Log.isDebuggable(this);
}

public static MyApplication getInstance() {
        return sMyApplication;
}

public boolean isDebbagable() {
	return debuggable;
}
```

Now use call the "isDebuggable" method to auto detect method name while printing.

```java
Log.v("MainActivity", "My message", MyApplication.getInstacne().isDebuggalbe());
```

The method name will be auto detected only if the app is in debug mode.

now you can tell your application to auto detect method name eve in release mode by calling log with true as last param
```java
Log.v("MainActivity", "My message", true);
```
If you know that you always need the class name ad method name even in release mode, then use
```java
Log.v("Your log message");
```
Note: *It is highly recommended not to use auto detection in frequent places like loops, inputstream reads etc...*


