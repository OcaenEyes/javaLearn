package v1;

public class TeachersModel {
    private int tno;
    private String tname;
    private String tsex;
    private String tbirthday;
    private String prof;
    private String depart;

    public int getTno() {
        return tno;
    }

    public String getTname() {
        return tname;
    }

    public String getTsex() {
        return tsex;
    }

    public String getTbirthday() {
        return tbirthday;
    }

    public String getProf() {
        return prof;
    }

    public String getDepart() {
        return depart;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public void setTbirthday(String tbirthday) {
        this.tbirthday = tbirthday;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
}
