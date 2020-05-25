package com.example.tunnel.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tunnel.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.tunnel.activity.footage2;

public class listview_footage extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> data;
    private String fileName = "tunnel-demo.json";
    private ProgressDialog pd;

    List<String> tunnel_section=new ArrayList();//隧道分部
    List<String> tunnel_name=new ArrayList();//隧道名称
    List<String> tunnel_subface=new ArrayList();//掌子面
    List<String> rock_grade=new ArrayList();//主流程
    List<String> design_rock_grade=new ArrayList();//设计围岩等级
    List<String> report_footage=new ArrayList();//进尺数
    List<String> sum_footage=new ArrayList();//累计进尺数
    List<String> explanation=new ArrayList();//备注
    List<String> save_time=new ArrayList();//保存时间
    List<String> upload_time=new ArrayList();//上报时间

    List<String> tunnel_id=new ArrayList();
    List<String> process_id=new ArrayList();

    List<String> user_name=new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_footage);


        init();
        pd.show();

        new DataThread().start();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String result=parent.getItemAtPosition(position).toString();




                Bundle bundle = new Bundle();
                bundle.putString("rock_grade",rock_grade.get(position));
                bundle.putString("tunnel_section",tunnel_section.get(position));
                bundle.putString("tunnel_name", tunnel_name.get(position));
                bundle.putString("tunnel_subface", tunnel_subface.get(position));
                bundle.putString("design_rock_grade", design_rock_grade.get(position));
                bundle.putString("report_footage", report_footage.get(position));
                bundle.putString("sum_footage", sum_footage.get(position));
                bundle.putString("save_time", save_time.get(position));
                bundle.putString("upload_time", upload_time.get(position));
                bundle.putString("report_footage", report_footage.get(position));
                bundle.putString("tunnel_id", tunnel_id.get(position));
                bundle.putString("process_id", process_id.get(position));

                bundle.putString("user_name", user_name.get(position));
                bundle.putString("explanation", explanation.get(position));




                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(listview_footage.this, footage2.class);

                startActivity(intent);
            }
        });



    }


    /**
     * 初始化
     */
    private void init() {
        listView = (ListView) findViewById(R.id.listView);
        data = new ArrayList<Map<String, Object>>();
        pd = new ProgressDialog(this);
        pd.setMessage("数据加载中……");

    }


    /**
     * 加载数据线程
     */
    class DataThread extends Thread {

        @Override
        public void run() {
            String jsonStr = getJson(fileName);
            setData(jsonStr);
            dataHandler.sendMessage(dataHandler.obtainMessage());
        }

    }




    /**
     * 加载数据线程完成处理Handler
     */
    Handler dataHandler = new Handler() {


        public void handleMessage(android.os.Message msg) {
            //t统计有多少条信息
            TextView textView_amount=(TextView)findViewById(R.id.textView_amount);
            textView_amount.setText("全部("+data.size()+")条");
            
            if (pd != null) {
                pd.dismiss();
            }
            SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                    data, R.layout.listview_item_footage,
                    new String[]{"tunnel_name","rock_grade","tunnel_section","imageview_time","upload_time","imageview_card","user_name","imageview_picture" ,"tunnel_subface"},
                    new int[]{R.id.tunnel_name,R.id.rock_grade,R.id.tunnel_section, R.id.imageview_time,R.id.upload_time,R.id.imageview_card, R.id.user_name,R.id.imageview_picture,R.id.tunnel_subface});
            listView.setAdapter(adapter);


        }
    };

    /**
     * 读取本地文件中JSON字符串
     *
     * @param fileName
     * @return
     */
    private String getJson(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    getAssets().open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 将JSON字符串转化为Adapter数据
     *
     * @param str
     */
    private void setData(String str) {
        try {

            JSONArray array = new JSONArray(str);
            int len = array.length();
            Map<String, Object> map;
            for (int i = 0; i < len; i++) {
                JSONObject object = array.getJSONObject(i);
                map = new HashMap<String, Object>();

                map.put("tunnel_name", object.getString("tunnel_name"));
                map.put("rock_grade", object.getString("rock_grade"));
                map.put("tunnel_section", object.getString("tunnel_section"));
                map.put("imageview_time",R.drawable.time);
                map.put("upload_time", object.getString("upload_time"));
                map.put("imageview_card",R.drawable.card);
                map.put("user_name", object.getString("user_name"));
                map.put("imageview_picture",R.drawable.picture);
                map.put("save_time",object.getString("save_time"));
                map.put("tunnel_subface",object.getString("tunnel_subface"));
                map.put("report_footage",object.getString("report_footage"));
                map.put("tunnel_id",object.getString("tunnel_id"));

                data.add(map);


                tunnel_section.add(object.getString("tunnel_section"));
                tunnel_name.add(object.getString("tunnel_name"));
                save_time.add(object.getString("save_time"));
                upload_time.add(object.getString("upload_time"));
                report_footage.add(object.getString("report_footage"));
                tunnel_id.add(object.getString("tunnel_id"));
                process_id.add(object.getString("process_id"));
                user_name.add(object.getString("user_name"));
                design_rock_grade.add(object.getString("design_rock_grade"));
                explanation.add(object.getString("explanation"));
                tunnel_subface.add(object.getString("tunnel_subface"));
                rock_grade.add(object.getString("rock_grade"));
                sum_footage.add(object.getString("sum_footage"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }




}
