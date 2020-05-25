package com.example.tunnel.Bean;

import java.security.Timestamp;

public class Jinchi {

    // 隧道标段
    private String tunnel_section;
    //隧道名称
    private String tunnel_name;
    //掌子面
    private String tunnel_subface;
    //主流程
    private String rock_grade;
    //设计围岩等级
    private String design_rock_grade;

    //进尺数
    private String report_footage;
    // 累计进尺数
    private String sum_footage;
    //备注
    private String explanation;
    //保存时间
    private Timestamp save_time;
    //上报时间
    private Timestamp upload_time;

    public Jinchi()
    {
        super();
    }

    public void setTunnel_section(String tunnel_section) {
        this.tunnel_section = tunnel_section;
    }

    public String getTunnel_section() {
        return tunnel_section;
    }


    public void setTunnel_name(String tunnel_name) {
        this.tunnel_name = tunnel_name;
    }

    public String getTunnel_name() {
        return tunnel_name;
    }

    public void setTunnel_subface(String tunnel_subface) {
        this.tunnel_subface = tunnel_subface;
    }

    public String getTunnel_subface() {
        return tunnel_subface;
    }

    public void setRock_grade(String rock_grade) {
        this.rock_grade = rock_grade;
    }

    public String getRock_grade() {
        return rock_grade;
    }

    public void setDesign_rock_grade(String design_rock_grade) {
        this.design_rock_grade = design_rock_grade;
    }

    public String getDesign_rock_grade() {
        return design_rock_grade;
    }

    public void setReport_footage(String report_footage) {
        this.report_footage = report_footage;
    }

    public String getReport_footage() {
        return report_footage;
    }

    public void setSum_footage(String sum_footage) {
        this.sum_footage = sum_footage;
    }

    public String getSum_footage() {
        return sum_footage;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setSave_time(Timestamp save_time) {
        this.save_time = save_time;
    }

    public Timestamp getSave_time() {
        return save_time;
    }

    public void setUpload_time(Timestamp upload_time) {
        this.upload_time = upload_time;
    }

    public Timestamp getUpload_time() {
        return upload_time;
    }


}
