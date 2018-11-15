package com.nana.widgets;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MToast {
    /**
     * default style ,show at bottom
     *
     * @param context
     * @param msg
     */
    public static void show(Context context, String msg) {
        Toast.makeText(context.getApplicationContext(), msg,
                Toast.LENGTH_SHORT).show();
    }

    public static void showInCenter(Context context, String msg) {
        Toast toast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showWithImage(Context context,String msg, int resId) {
        Toast toast = Toast.makeText(context.getApplicationContext(),
                msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(context.getApplicationContext());
        imageCodeProject.setImageResource(resId);
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }

    public static void showCustomView(Context context, String title,String msg, int resId) {
        //Activity.getLayoutInflater() or Context.getSystemService(Class) to retrieve a standard LayoutInflater instance
        //Instances of this class must be obtained using Context.getSystemService(Class) with the argument LayoutInflater.class
        // or Context.getSystemService(String) with the argument Context.LAYOUT_INFLATER_SERVICE.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.view_custom_toast,null);
        ImageView image = layout
                .findViewById(R.id.iv_toast_img);
        image.setImageResource(resId);
        TextView tvTitle = layout.findViewById(R.id.tv_toast_title);
        tvTitle.setText(title);
        TextView tvMsg = layout.findViewById(R.id.tv_toast_msg);
        tvMsg.setText(msg);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.RIGHT | Gravity.TOP, 12, 40);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}
