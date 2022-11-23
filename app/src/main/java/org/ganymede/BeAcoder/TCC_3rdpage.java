package org.ganymede.BeAcoder;

public class TCC_3rdpage {
    private String Savetopics;
    private String TOverview;
    private String Codeoverview;

    public TCC_3rdpage() {
    }

    public TCC_3rdpage(String Savetopics,String TOverview, String Codeoverview) {
        this.Savetopics = Savetopics;
        this.TOverview = TOverview;
        this.Codeoverview = Codeoverview;

    }

    public String getCOverview() {
        return Savetopics;
    }

    public void setTName(String COverview) {
        this.Savetopics = Savetopics;
    }

    public String getTOverview() {
        return TOverview;
    }

    public void setTOverview(String TOverview) {
        this.TOverview = TOverview;
    }

    public String getCodeoverview() {
        return Codeoverview;
    }

    public void setCodeoverview(String Codeoverview) {
        this.Codeoverview = Codeoverview;
    }



}
