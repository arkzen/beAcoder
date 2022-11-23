package org.ganymede.BeAcoder;

public class TeacherCreatecourse {

    private String TName;
    private String TEmail;
    private String CName;
    private String CCode;

    public TeacherCreatecourse() {
    }

    public TeacherCreatecourse(String TName, String TEmail, String CName,String CCode) {
        this.TName = TName;
        this.TEmail = TEmail;
        this.CName = CName;
        this.CCode = CCode;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getTEmail() {
        return TEmail;
    }

    public void setTEmail(String TEmail) {
        this.TEmail = TEmail;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCCode() {
        return CCode;
    }

    public void setCCode(String CCode) {
        this.CCode = CCode;
    }


}
