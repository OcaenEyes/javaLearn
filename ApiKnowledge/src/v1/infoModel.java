package v1;

public class infoModel {
    private int id;
    private String imgUrl;
    private String textNum;
    private String imgAuther;
    private String textContent;
    private String mon;
    private String day;

    public int getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgAuther() {
        return imgAuther;
    }

    public String getTextNum() {
        return textNum;
    }

    public String getTextContent() {
        return textContent;
    }

    public String getMon() {
        return mon;
    }

    public String getDay() {
        return day;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public void setImgAuther(String imgAuther){
        this.imgAuther = imgAuther;
    }

    public void setTextNum(String textNum){
        this.textNum =textNum;
    }

    public void setTextContent(String textContent){
        this.textContent = textContent;
    }

    public void setMon(String mon){
        this.mon =mon;
    }

    public void setDay(String day){
        this.day =day;
    }

}
