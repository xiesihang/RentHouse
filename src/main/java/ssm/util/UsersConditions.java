package ssm.util;

public class UsersConditions {
    //条件参数
    private String name;
    private String telephone;

    //分页参数
    private Integer page;
    private Integer rows;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

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

    @Override
    public String toString() {
        return "UsersConditions{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
