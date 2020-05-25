package com.example.tunnel.adapter;//package com.example.tunnle.adapter;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//
//public class GalleryAdapter  extends BaseAdapter {
//    private Context mContext;
//    private int mPos;
//    public GalleryAdapter(Context context) {
//        mContext = context;
//    }
//    public void setOwnposition(int ownposition) {
//        this.mPos = ownposition;
//    }
//    public int getOwnposition() {
//        return mPos;
//    }
//    @Override
//    public int getCount() {
//        return ImageSource.mThumbIds.length;
//    }
//    @Override
//    public Object getItem(int position) {
//        mPos=position;
//        return position;
//    }
//    @Override
//    public long getItemId(int position) {
//        mPos=position;
//        return position;
//    }
//
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        mPos=position;
//        ImageView imageview = new ImageView(mContext);
//        imageview.setBackgroundColor(0xFF000000);
//        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        imageview.setLayoutParams(new myGallery.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//        imageview.setImageResource(ImageSource.mThumbIds[position]);
//        return imageview;
//    }
//}
