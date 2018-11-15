package com.nana.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;

public class DisplayUtil {

    public static Point getWindowSize(Context context) {
        int[] size = new int[2];
        Point point = new Point();
        WindowManager windowManager = getWindowManager(context);
        //added api 13 and getWidth(),getHeight deprecated at api 13
        windowManager.getDefaultDisplay().getSize(point);
        return point;
    }

    public static int getWindowWidth(Context context) {
        Point point = getWindowSize(context);
        return point.x;
    }

    public static int getWindowHeight(Context context) {
        Point point = getWindowSize(context);
        return point.y;
    }

    private static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
    }

    /**
     * 获取在当前屏幕内的绝对坐标
     * 注意这个值是要从屏幕顶端算起，也就是说包括了通知栏的高度
     * 数组中location[0]代表的是x坐标，location[1]代表的是y坐标。
     *
     * @param view
     * @return
     */
    public static int[] getViewRealLocation(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return location;
    }

    public static int getViewWidth(View view) {
        return view.getMeasuredWidth();
    }

    public static int getViewHeight(View view) {
        return view.getMeasuredHeight();
    }

    public static int[] getViewSize(View view) {
        int[] size = new int[2];
        //获取控件的高度
        size[0] = getViewWidth(view);
        //获取控件的宽度
        size[1] = getViewHeight(view);
        return size;
    }


}
