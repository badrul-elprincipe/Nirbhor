package com.badrul.user.bracexel;

public class userdata {
    private String pon;
    private String von;
    private String name;
    private int bamount;
    private int cinstallment;
    private int overdue;
    private int outstanding;
    private double ratio;
    private String qcha;
    private String qed;
    private String qBP;
    private String qsavings;
    private String qDis;
    private String qSan;
    private String growth;
    private String quality;


    public userdata(String pon,String von, String name, int bamount, int cinstallment, int overdue, int outstanding,double ratio,String qcha,String qed,String qBP,String qsavings,String qDis,String qSan,String growth,String quality) {
        this.pon = pon;
        this.von = von;
        this.name = name;

        this.bamount = bamount;
        this.cinstallment = cinstallment;
        this.overdue = overdue;
        this.outstanding = outstanding;
        this.ratio=ratio;
        this.qcha=qcha;
        this.qed=qed;
        this.qBP=qBP;
        this.qsavings=qsavings;
        this.qDis=qDis;
        this.qSan=qSan;
        this.growth=growth;
        this.quality=quality;

    }

    public String getPon() {
        return pon;
    }

    public void setPon(String pon) {
        this.pon = pon;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBamount() {
        return bamount;
    }

    public void setBamount(int bamount) {
        this.bamount = bamount;
    }

    public int getCinstallment() {
        return cinstallment;
    }

    public void setCinstallment(int cinstallment) {
        this.cinstallment = cinstallment;
    }

    public int getOverdue() {
        return overdue;
    }

    public void setOverdue(int overdue) {
        this.overdue = overdue;
    }

    public int getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(int outstanding) {
        this.outstanding = outstanding;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getQcha() {
        return qcha;
    }

    public void setQcha(String qcha) {
        this.qcha = qcha;
    }

    public String getQed() {
        return qed;
    }

    public void setQed(String qed) {
        this.qed = qed;
    }

    public String getqBP() {
        return qBP;
    }

    public void setqBP(String qBP) {
        this.qBP = qBP;
    }

    public String getQsavings() {
        return qsavings;
    }

    public void setQsavings(String qsavings) {
        this.qsavings = qsavings;
    }

    public String getqDis() {
        return qDis;
    }

    public void setqDis(String qDis) {
        this.qDis = qDis;
    }

    public String getqSan() {
        return qSan;
    }

    public void setqSan(String qSan) {
        this.qSan = qSan;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
