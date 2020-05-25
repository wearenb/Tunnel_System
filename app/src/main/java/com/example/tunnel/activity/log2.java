package com.example.tunnel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tunnel.R;
import com.example.tunnel.adapter.ImageAdapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class log2 extends AppCompatActivity {
    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    //声明控件
    private GridView lv_images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log2);

// 获取ListView对象
        lv_images = (GridView) findViewById(R.id.imagelist_log);

        Bundle bundle = getIntent().getExtras();

        String tunnel_section = bundle.getString("tunnel_section");

        String save_time = bundle.getString("save_time");
        String upload_time = bundle.getString("upload_time");
        String explanation = bundle.getString("explanation");

        String rock_grade = bundle.getString("rock_grade");
        String user_name = bundle.getString("user_name");
        String tunnel_name = bundle.getString("tunnel_name");
        String photos=bundle.getString("photos");
        String tunnel_subface = bundle.getString("tunnel_subface");
        String tunnel_subprocess = bundle.getString("tunnel_subprocess");

        //获取数据
        if(photos!="无图片") {
            getData(photos);
            BaseAdapter adapter = new ImageAdapter(this, data);
            //设置适配器
            lv_images.setAdapter(adapter);
        }

        TextView tv_tunnel_name = (TextView) findViewById(R.id.tv_tunnel_name_log1);
        tv_tunnel_name.setText(tunnel_name);

        TextView tv_rock_grade_log1 = (TextView) findViewById(R.id.tv_rock_grade_log1);
        tv_rock_grade_log1.setText(rock_grade);

        TextView tv_tunnel_subface = (TextView) findViewById(R.id.tv_tunnel_subface_log1);
        tv_tunnel_subface.setText(tunnel_subface);

        TextView tv_upload_log = (TextView) findViewById(R.id.tv_upload_log);
        tv_upload_log.setText(user_name + "上传于" + upload_time);

        TextView tv_tunnel_section = (TextView) findViewById(R.id.tv_tunnel_section_log);
        tv_tunnel_section.setText("隧道标段：" + tunnel_section);

        TextView tv_tunnel_name_log = (TextView) findViewById(R.id.tv_tunnel_name_log);
        tv_tunnel_name_log.setText("隧道名称：" + tunnel_name);

        TextView tv_tunnel_subface_log = (TextView) findViewById(R.id.tv_tunnel_subface_log);
        tv_tunnel_subface_log.setText("掌子面：" + rock_grade);

        TextView tv_rock_grade_log = (TextView) findViewById(R.id.tv_rock_grade_log);
        tv_rock_grade_log.setText("主流程：" + tunnel_subface);

        TextView tv_tunnel_subprocess_log = (TextView) findViewById(R.id.tv_tunnel_subprocess_log);
        tv_tunnel_subprocess_log.setText("子流程：" + tunnel_subprocess);

        TextView tv_user_name_log = (TextView) findViewById(R.id.tv_user_name_log);
        tv_user_name_log.setText("上报人：" + user_name);

        TextView tv_explanation_log = (TextView) findViewById(R.id.tv_explanation_log);
        tv_explanation_log.setText("备注：" + explanation);


        TextView tv_save_time = (TextView) findViewById(R.id.tv_save_time_log);
        tv_save_time.setText("保存时间：" + save_time);

        TextView tv_upload_time = (TextView) findViewById(R.id.tv_upload_time_log);
        tv_upload_time.setText("上传时间：" + upload_time);

        ImageView ItemImage=(ImageView) findViewById(R.id.imagetest);


        ImageButton button_back = (ImageButton) findViewById(R.id.imageButton_back_log);
        button_back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );


    }

    /**
     * 简单添加一些网络图片的url路径
     * 实际开发中url路径是从服务器中解析json数据
     */
    public void getData(String photos) {

        String []result=photos.split(",");
        for(int i=0;i<result.length;i++)
        {

            String  url="http://39.100.33.169:8080/upload/"+result[i];
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("url", url);
            data.add(map);
        }
    }
            }

