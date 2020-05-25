package com.example.tunnel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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



public class
log1 extends AppCompatActivity {
    private ListView listView;
    private List<Map<String, Object>> data;
    private String fileName = "tunnel-log.json";
    private ProgressDialog pd;

    List<String> tunnel_section = new ArrayList();
    List<String> tunnel_name = new ArrayList();
    List<String> save_time = new ArrayList();
    List<String> upload_time = new ArrayList();
    List<String> rock_grade = new ArrayList();
    List<String> user_name = new ArrayList();
    List<String> photos = new ArrayList();
    List<String> tunnel_subface = new ArrayList();
    List<String> tunnel_subprocess = new ArrayList();
    List<String> explanation = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_log);

        init();
        pd.show();

        new DataThread().start();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String result=parent.getItemAtPosition(position).toString();


                Bundle bundle = new Bundle();
                bundle.putString("tunnel_section", tunnel_section.get(position));
                bundle.putString("tunnel_name", tunnel_name.get(position));
                bundle.putString("save_time", save_time.get(position));
                bundle.putString("upload_time", upload_time.get(position));
                bundle.putString("rock_grade", rock_grade.get(position));
                bundle.putString("user_name", user_name.get(position));
                bundle.putString("explanation", explanation.get(position));
                bundle.putString("tunnel_subface", tunnel_subface.get(position));
                bundle.putString("tunnel_subprocess", tunnel_subprocess.get(position));
                bundle.putString("photos", photos.get(position));


                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(log1.this, log2.class);

                startActivity(intent);
            }
        });


    }

    /**
     * 初始化
     */
    private void init() {
        listView = (ListView) findViewById(R.id.listview_log);
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
            try {
                setData(jsonStr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dataHandler.sendMessage(dataHandler.obtainMessage());
        }

    }

    /**
     * 加载数据线程完成处理Handler
     */
    Handler dataHandler = new Handler() {


        public void handleMessage(android.os.Message msg) {
            //t统计有多少条信息
            TextView textView_amount = (TextView) findViewById(R.id.textView_amount_log);
            textView_amount.setText("全部(" + data.size() + ")条");

            if (pd != null) {
                pd.dismiss();
            }
            SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                    data, R.layout.listview_item_log,
                    new String[]{"tunnel_name", "rock_grade", "tunnel_subface", "imageview_time", "upload_time", "imageview_card", "user_name", "imageview_picture", "photos"},
                    new int[]{R.id.tunnel_name, R.id.rock_grade, R.id.tunnel_subface, R.id.imageview_time, R.id.upload_time, R.id.imageview_card, R.id.user_name, R.id.imageview_picture, R.id.photos});
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
    private void setData(String str) throws JSONException {

//        MainActivity m=new MainActivity();
//        List<String> a=m.checkbox_select();


        JSONArray array = new JSONArray(str);
        int len = array.length();
        Map<String, Object> map;
        for (int i = 0; i < len; i++) {

                JSONObject object = array.getJSONObject(i);
                map = new HashMap<String, Object>();

//                for(int j=0;j<a.size();j++)
//                {
//                    if ((object.getString("tunnel_name")+object.getString("tunnel_subface")).equals(a.get(j)))
//                    {


                map.put("tunnel_name", object.getString("tunnel_name"));
                map.put("rock_grade", object.getString("rock_grade"));
                map.put("tunnel_subface", object.getString("tunnel_subface"));
                map.put("imageview_time", R.drawable.time);
                map.put("upload_time", object.getString("upload_time"));
                map.put("imageview_card", R.drawable.card);
                map.put("user_name", object.getString("user_name"));
                map.put("imageview_picture", R.drawable.picture);
                    try {
                       if(object.getString("photos")!=null);
                        {
                            map.put("photos", "有图片");
                            photos.add(object.getString("photos"));

//                        photo  URL分割及处理
//                        String photo=object.getString("photos");
//                        String []result=photo.split(",");

                            data.add(map);
                        }

            }



            catch (JSONException e) {
                e.printStackTrace();
               map.put("photos", "无图片");
                photos.add("无图片");
                data.add(map);
                    }
            tunnel_name.add(object.getString("tunnel_name"));
            rock_grade.add(object.getString("rock_grade"));
            tunnel_subface.add(object.getString("tunnel_subface"));//掌子面
            tunnel_section.add(object.getString("tunnel_section"));
            tunnel_subprocess.add(object.getString("subprocess"));//子进程
            save_time.add(object.getString("save_time"));
            upload_time.add(object.getString("upload_time"));
            user_name.add(object.getString("user_name"));

//                    photos.add(object.getString("photos"));


            explanation.add(object.getString("explanation"));//备注
        }


    }
}
