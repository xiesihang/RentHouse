package ssm.util;

import ssm.pojo.Page;

public class HouseConditions {
    //分页参数
    private Integer page=1;
    private Integer rows=4;
    //条件参数
    private String title;
    private Integer type;
    private Integer district;
    private Integer street;
    private Integer start;
    private Integer end;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getStreet() {
        return street;
    }

    public void setStreet(Integer street) {
        this.street = street;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "HouseConditions{" +
                "page=" + page +
                ", rows=" + rows +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", district=" + district +
                ", street=" + street +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
