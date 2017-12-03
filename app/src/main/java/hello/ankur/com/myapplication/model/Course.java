package hello.ankur.com.myapplication.model;

import java.util.Map;

/**
 * Created by ASUS on 12/2/2017.
 */

public class Course {

    public String name;
    public String teacher1;
    public String teacher2;
    public Integer totalContent;

    public Map<String, String> chothas;

    public Course() {
    }

    public Course(String name, String teacher1, String teacher2, Integer totalContent, Map<String, String> chothas) {
        this.name = name;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
        this.totalContent = totalContent;
        this.chothas = chothas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(String teacher1) {
        this.teacher1 = teacher1;
    }

    public String getTeacher2() {
        return teacher2;
    }

    public void setTeacher2(String teacher2) {
        this.teacher2 = teacher2;
    }

    public Integer getTotalContent() {
        return totalContent;
    }

    public void setTotalContent(Integer totalContent) {
        this.totalContent = totalContent;
    }

    public Map<String, String> getChothas() {
        return chothas;
    }

    public void setChothas(Map<String, String> chothas) {
        this.chothas = chothas;
    }
}
