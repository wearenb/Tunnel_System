package com.example.tunnel.adapter;//package com.example.tunnle.adapter;
//
//import android.app.Activity;
//import android.graphics.Bitmap;
//import android.graphics.drawable.Drawable;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.tunnel.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class GridViewAdapter extends BaseAdapter {
//
//    List<GridViewData> datas = new ArrayList<GridViewData>();
//
//    GridView gridview;
//
//    Activity activity;
//
//    LayoutInflater inflater;
//
//    AsyncImageLoader asyncImageLoader;
//
//    /**
//     * 实例化adapter并接收传递的数据
//     * @param activity
//     * @param datas
//     * @param gridview
//     */
//    public GridViewAdapter(Activity activity, List<GridViewData> datas, GridView gridview){
//        this.activity = activity;
//        this.datas = datas;
//        this.gridview = gridview;
//
//        //实例化LayoutInflater
//        inflater = activity.getLayoutInflater();
//        //实例化异步加载图片的类
//        asyncImageLoader = new AsyncImageLoader();
//    }
//
//    /**
//     * 这个方法是显示的图片的个数
//     * @return 取决于datas的大小
//     */
//    @Override
//    public int getCount() {
//        return datas.size();
//    }
//
//    /**
//     * 获取每一个item的数据
//     * @param position
//     * @return
//     */
//    @Override
//    public GridViewData getItem(int position) {
//        return datas.get(position);
//    }
//
//    /**
//     * getItemId
//     * @param position
//     * @return
//     */
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    /**
//     * 每加载一次系统调用一次
//     * @param position
//     * @param convertView
//     * @param parent
//     * @return
//     */
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        //当回收的view为空，重新获取
//        if(convertView == null){
//            convertView = inflater.inflate(R.layout.gridview_item_log, null);
//        }
//        convertView.setTag(position);
//        //拿到每一个item的值
//        GridViewData info = getItem(position);
//
//        //使用异步加载图片的类加载图片并实现回调
//        asyncImageLoader.loadDrawable(position, info.img_url, new AsyncImageLoader.ImageCallback() {
//
//
//
//            @Override
//            public void onImageLoad(Integer t, Drawable drawable) {
//                View view = gridview.findViewWithTag(t);
//                if(view != null){
//                    Log.i("TAG", "加载成功...");
//                    ImageView iv = view.findViewById(R.id.ItemImage);
//                    iv.setBackgroundDrawable(drawable);
//                }
//            }
//
//
//            @Override
//            public void onError(Integer t) {
//                View view = gridview.findViewWithTag(t);
//                if(view != null){
//                    Log.i("TAG", "加载失败...");
//                    ImageView img_url = view.findViewById(R.id.ItemImage);
//                    //加载中或者加载失败，默认加载app图标
//                    img_url.setBackgroundResource(R.mipmap.ic_launcher);
//                }
//            }
//        });
//
//
//
//
//
//        return convertView;
//    }
//}
//
//
