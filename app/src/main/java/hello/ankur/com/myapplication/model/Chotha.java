package hello.ankur.com.myapplication.model;

/**
 * Created by ASUS on 12/2/2017.
 */

public class Chotha {
    public String name;
    public String link;
    public String uploader;

    public Chotha() {
    }

    public Chotha(String name, String link, String uploader) {
        this.name = name;
        this.link = link;
        this.uploader = uploader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
