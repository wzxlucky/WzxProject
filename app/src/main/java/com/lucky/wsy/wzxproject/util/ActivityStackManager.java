package com.lucky.wsy.wzxproject.util;

import java.util.Stack;

import android.app.Activity;


/**
 * 
 * 具体使用方法就是将其手动在activity初始化时调用 ActivityStackManager.getActivityStackManager().pushActivity(activity);
在onDestroy方法中调用ActivityStackManager.getActivityStackManager().popActivity(activity); 
一般情况下为了方便都是封装到baseactivity中,处理逻辑时，比如关闭全部activity直接调用popAllActivity()； 
并且该工具类是线程安全的，不会出现多线程拥挤出错问题。
 *
 */
public class ActivityStackManager {

	private static final String TAG = "ActivityStackManager";
    private static Stack<Activity> activityStack;

    private static ActivityStackManager instance;

    private ActivityStackManager() {
    }

    public synchronized static ActivityStackManager getActivityStackManager() {
        if (instance == null) {
            instance = new ActivityStackManager();
        }
        return instance;
    }
    
    /**
     * 关闭activity
     */
    public synchronized void popActivity() {
        Activity activity = activityStack.lastElement();
        if (activity != null) {
            activity.finish();
            activity = null;
        }
    }
    
    /**
     * 关闭指定activity
     *
     * @param activity activity
     */
    public synchronized void popActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }
    
    /**
     * 获取activity堆栈中的最后一个activity
     *
     * @return activity
     */
    private synchronized Activity currentActivity() {
        Activity activity;
        if (activityStack.size() > 0) {
            activity = activityStack.lastElement();
        } else {
            activity = null;
        }


        return activity;
    }
    
    /**
     * 添加activity
     *
     * @param activity activity
     */
    public synchronized void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }
    
    /**
     * 移除除了某个activity的其他所有activity
     *
     * @param cls 界面
     */
    public synchronized void popAllActivityExceptOne(Class cls) {
        for (int i = 0; i < activityStack.size(); i++) {
            Activity activity = activityStack.get(i);
            if (activity.getClass().equals(cls)) {
                break;
            }
            popActivity(activity);
        }
    }
    
    /**
     * 移除所有activity
     */
    public synchronized void popAllActivity() {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            popActivity(activity);
        }
    }
}
