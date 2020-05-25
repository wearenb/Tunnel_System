package com.example.tunnel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tunnel.R;

public class footage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footage2);

        Bundle bundle=getIntent().getExtras();

        String tunnel_section=bundle.getString("tunnel_section");
        String tunnel_name=bundle.getString("tunnel_name");
        String tunnel_subface=bundle.getString("tunnel_subface");
        String rock_grade=bundle.getString("rock_grade");
        String design_rock_grade=bundle.getString("design_rock_grade");
        String report_footage=bundle.getString("report_footage");
        String sum_footage=bundle.getString("sum_footage");
        String explanation=bundle.getString("explanation");
        String save_time=bundle.getString("save_time");
        String upload_time=bundle.getString("upload_time");
        String tunnel_id=bundle.getString("tunnel_id");
        String process_id=bundle.getString("process_id");
        String user_name=bundle.getString("user_name");








        TextView tv_tunnel_section=(TextView) findViewById(R.id.tv_tunnel_section);
        tv_tunnel_section.setText("隧道标段："+tunnel_section);

        TextView tv_tunnel_id=(TextView) findViewById(R.id.tv_tunnel_id);
        tv_tunnel_id.setText("隧道名称："+tunnel_id);


        TextView tv_tunnel_subface=(TextView) findViewById(R.id.tv_tunnel_subface);
        tv_tunnel_subface.setText("掌子面："+tunnel_subface);

        TextView tv_rock_grade_footage=(TextView) findViewById(R.id.tv_rock_grade_footage);
        tv_rock_grade_footage.setText("主流程："+rock_grade);


        TextView tv_design_rock_grade=(TextView) findViewById(R.id.tv_design_rock_grade);
        tv_design_rock_grade.setText("设计围岩等级："+design_rock_grade);

        TextView tv_report_footage=(TextView) findViewById(R.id.tv_report_footage);
        tv_report_footage.setText("进尺数："+report_footage);

        TextView tv_sum_footage=(TextView) findViewById(R.id.tv_sum_footage);
        tv_sum_footage.setText("累计进尺数："+sum_footage);

        TextView tv_explanation=(TextView) findViewById(R.id.tv_explanation);
        tv_explanation.setText("备注："+explanation);

        TextView tv_save_time=(TextView) findViewById(R.id.tv_save_time);
        tv_save_time.setText("保存时间："+save_time);

        TextView tv_upload_time=(TextView) findViewById(R.id.tv_upload_time);
        tv_upload_time.setText("上传时间："+upload_time);

        TextView tv_tunnel_name=(TextView) findViewById(R.id.tv_tunnel_name);
        tv_tunnel_name.setText(tunnel_name);

        TextView tv_process_id=(TextView) findViewById(R.id.tv_process_id);
        tv_process_id.setText(process_id);

        TextView tv_rock_grade=(TextView) findViewById(R.id.tv_rock_grade);
        tv_rock_grade.setText(rock_grade);

        TextView tv_upload=(TextView) findViewById(R.id.tv_upload);
        tv_upload.setText( user_name+"上传于"+upload_time);




        ImageButton button_back=(ImageButton)findViewById(R.id.imageButton_back);
        button_back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

    }
}
