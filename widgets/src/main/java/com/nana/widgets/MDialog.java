package com.nana.widgets;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 需要参考dialog的源码
 * https://www.cnblogs.com/butterfly-clover/p/4000509.html
 */
public class MDialog extends Dialog {
    public MDialog(@NonNull Context context) {
        super(context);
    }

    public MDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
