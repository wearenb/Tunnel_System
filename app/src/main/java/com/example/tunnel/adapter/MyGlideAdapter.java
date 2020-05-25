package com.example.tunnel.adapter;//package com.example.tunnle.adapter;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//
//import com.bumptech.glide.Glide;
//import com.example.tunnel.R;
//
//import java.util.List;
//
//public class MyGlideAdapter extends BaseAdapter{
//    private Context mContext;
//    private List<String> mUrls;
//    private LayoutInflater layoutInflater;
//    public MyGlideAdapter(Context context, List<String> urls) {
//        this.mContext = context;
//        this.mUrls = urls;
//        layoutInflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return mUrls.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mUrls.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        MyViewHold myViewHold=null;
//        if(convertView==null){
//            convertView = layoutInflater.inflate(R.layout.gridview_item_log,null);
//            myViewHold = new MyViewHold();
//            myViewHold.imageView = (ImageView) convertView.findViewById(R.id.ItemImage);
//            convertView.setTag(myViewHold);
//        }else{
//            myViewHold = (MyViewHold) convertView.getTag();
//        }
//        Glide.with(mContext).load(mUrls.get(position)).into(myViewHold.imageView);
//        return convertView;
//    }
//}
//class MyViewHold {
//    public ImageView imageView;
//}
