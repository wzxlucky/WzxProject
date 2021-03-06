package com.lucky.wsy.wzxproject.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * dp,sp转换为px的工具类
 */
public class DisplayUtil {
	/**
	 * 将px值转换为dip或dp值,保证尺寸大小不变
	 * 
	 * @param pxValue
	 * @param scale
	 *            (DisplayMetrics类中属性density)
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 
	 * 将dip或dp值转换为px值,保证尺寸大小不变
	 * 
	 * @param scale
	 * @param dipValue
	 *            (DisplayMetrics类中属性density)
	 * @return
	 */
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue / scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值,保证文字大小不变
	 * 
	 * @param fontScale
	 * @param pxValue
	 *            (DisplayMetrics类中属性density)
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值,保证文字大小不变
	 * 
	 * @param fontScale
	 * @param spValue
	 *            (DisplayMetrics类中属性density)
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale=context.getResources().getDisplayMetrics().density;
		return (int)(spValue*fontScale+0.5f);
	}
	
	/**
	 * @param context
	 * @return DisplayMetrics屏幕宽高
	 */
	public static DisplayMetrics getScreenSize(Context context)
	{
		DisplayMetrics metrics=new DisplayMetrics();
		WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		Display display=wm.getDefaultDisplay();
		display.getMetrics(metrics);
		return metrics;
	}
	
	
	/**
	 * @param context
	 * @return density 屏幕density
	 */
	public static float getDeviceDensity(Context context)
	{
		DisplayMetrics metrics=new DisplayMetrics();
		WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(metrics);
		return metrics.density;
	}
	
	
}
