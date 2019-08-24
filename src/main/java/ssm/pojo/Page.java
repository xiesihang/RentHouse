package ssm.pojo;

public class Page {
    private int currPage=1;
    private int rows=3;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currPage=" + currPage +
                ", rows=" + rows +
                '}';
    }
}
