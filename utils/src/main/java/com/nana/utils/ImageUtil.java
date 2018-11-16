package com.nana.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageUtil {
    /**
     * bitmap to bytes
     * @param bitmap
     * @return
     */
    public byte[] getBitmapByte(Bitmap bitmap){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //参数1转换类型，参数2压缩质量，参数3字节流资源
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    /**
     * bytes to bitmap
     * @param temp
     * @return
     */
    public Bitmap getBitmapFromByte(byte[] temp){
        if(temp != null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(temp, 0, temp.length);
            return bitmap;
        }else{
            return null;
        }
    }

    /**
     * byte to drawable
     * @param temp
     * @return
     */
    public Drawable getDrawableFromByte(byte[] temp){
        InputStream inputStream = new ByteArrayInputStream(temp);
        if(temp != null){
            Drawable drawable = Drawable.createFromStream(inputStream, "image");
            return drawable ;
        }else{
            return null;
        }
    }

    /**
     * drawable to bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable){

        int width = drawable.getIntrinsicWidth();

        int height = drawable.getIntrinsicHeight();

        Bitmap bitmap = Bitmap.createBitmap(width, height,

                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888

                        : Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(bitmap);

        drawable.setBounds(0,0,width,height);

        drawable.draw(canvas);

        return bitmap;

    }

    /**
     * drawable to bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap2(Drawable drawable){
        BitmapDrawable tempDrawable = (BitmapDrawable) drawable;
        return tempDrawable.getBitmap();
    }

    /**
     * 从网络获取bitmap
     * 这个方法还需要重新梳理下
     * @param url
     * @return
     */
    public static Bitmap getBitmapFromUrl(String url) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        ByteArrayOutputStream outstream = null;
        Bitmap bm = null;
        try {
            is = imageUrl.openStream();
            outstream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024]; // 用数据装
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outstream.write(buffer, 0, len);
            }
            bm = BitmapFactory.decodeByteArray(outstream.toByteArray(), 0, outstream.toByteArray().length);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outstream.close();   // 关闭流一定要记得。
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bm;
    }

    /**
     * bitmap compress
     * 可以设置压缩比例，也可以设置长、宽
     * 这个方法需要重新梳理
     * @param bitmap
     * @param scale
     * @return
     */
    public static Bitmap bitmapCompress(Bitmap bitmap,float scale){
        Bitmap bitmap1 = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);//arg1为传进来的原始bitmap

        baos.toByteArray();

        InputStream is = new ByteArrayInputStream(baos.toByteArray());

        //进行缩放

        BitmapFactory.Options newOpts = new BitmapFactory.Options();

        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了

        newOpts.inJustDecodeBounds = true;

        Bitmap bitmap2 = BitmapFactory.decodeStream(is,null,newOpts);// 此时返回bm为空

        newOpts.inJustDecodeBounds = false;

        int w = newOpts.outWidth;

        int h = newOpts.outHeight;

// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为

        float hh = 100f;// 这里设置高度为800f

        float ww = 100f;// 这里设置宽度为480f

// 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可

        int be = 1;// be=1表示不缩放

        if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放

            be = (int) (newOpts.outWidth / ww);

        } else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放

            be = (int) (newOpts.outHeight / hh);

        }

        if (be <= 0)

            be = 1;

        newOpts.inSampleSize = 2;// 设置缩放比例

// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了

        bitmap = BitmapFactory.decodeByteArray(baos.toByteArray(), 0, baos.toByteArray().length, newOpts);
        return bitmap1;
    }
}
