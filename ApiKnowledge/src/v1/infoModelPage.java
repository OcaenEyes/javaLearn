package v1;
import java.util.List;

public class infoModelPage {
    private int total;
    private List<infoModel> rows;

    public infoModelPage( int total,List<infoModel>rows){
        this.total = total;
        this.rows = rows;
    }

    public int getTotal(){
        return total;
    }

    public List<infoModel> getRows(){
        return rows;
    }

    public void setTotal(int total){
        this.total = total;
    }

    public void setRows(List<infoModel> rows){
        this.rows =rows;
    }
}
