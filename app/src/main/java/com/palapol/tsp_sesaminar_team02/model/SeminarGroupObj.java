package com.palapol.tsp_sesaminar_team02.model;

import java.util.ArrayList;

public class SeminarGroupObj {
    private ArrayList<RSStudent> rs_student;
    private ArrayList<RSMaster> rs_master;

    public ArrayList<RSStudent> getRs_student() {
        return rs_student;
    }

    public void setRs_student(ArrayList<RSStudent> rs_student) {
        this.rs_student = rs_student;
    }

    public ArrayList<RSMaster> getRs_master() {
        return rs_master;
    }

    public void setRs_master(ArrayList<RSMaster> rs_master) {
        this.rs_master = rs_master;
    }

    public ArrayList<String> GetStudentCodeAndName() {
        ArrayList<String> StudentCodeAndName = new ArrayList<String>();
        String tmp;
        for(RSStudent obj: rs_student){
            tmp = obj.getPs_code()+" "+obj.getPs_name();
            StudentCodeAndName.add(tmp);
        }
        return StudentCodeAndName;
    }

    public String GetTeacherName(){
        String TeacherName = new String();
        for(RSMaster obj: rs_master){
            TeacherName = "อาจารย์ที่ปรึกษา : "+obj.getGp_master_name();
        }
        return TeacherName;
    }
}

class RSStudent {
    private String ps_code;
    private String ps_name;

    RSStudent(){

    }

    public String getPs_code() {
        return ps_code;
    }

    public void setPs_code(String ps_code) {
        this.ps_code = ps_code;
    }

    public String getPs_name() {
        return ps_name;
    }

    public void setPs_name(String ps_name) {
        this.ps_name = ps_name;
    }
}

class RSMaster {
    private String gp_master;
    private String gp_master_name;

    RSMaster() {

    }

    public String getGp_master() {
        return gp_master;
    }

    public void setGp_master(String gp_master) {
        this.gp_master = gp_master;
    }

    public String getGp_master_name() {
        return gp_master_name;
    }

    public void setGp_master_name(String gp_master_name) {
        this.gp_master_name = gp_master_name;
    }
}
