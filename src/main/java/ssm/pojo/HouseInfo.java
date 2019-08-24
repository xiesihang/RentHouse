package ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HouseInfo {
    private String id;

    private String userName;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubdate;

    private String type;

    private String district;

    private String street;

    private Integer floorage;

    private String contact;

    private Long price;

    private String description;

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", pubdate=" + pubdate +
                ", type='" + type + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", floorage=" + floorage +
                ", contact='" + contact + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
