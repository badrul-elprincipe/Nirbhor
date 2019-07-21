package com.badrul.user.bracexel;

public class users {

        String id;

        String pon;
        String von;
        String name;
        String bamount;
        String cinstallment;
        String overdue;
        String outstanding;
        String ratio;
        String qcha;
        String qed;
        String qBP;
        String qsavings;
        String qDis;
        String qSan;
        String growth;
        String quality;


        public users(){

        }

        users(String id,String pon,String von, String name, String bamount, String cinstallment, String overdue, String outstanding,String ratio,String qcha,String qed,String qBP,String qsavings,String qDis,String qSan,String growth,String quality) {
            this.id=id;
            this.pon = pon;
            this.von=von;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBamount() {
        return bamount;
    }

    public void setBamount(String bamount) {
        this.bamount = bamount;
    }

    public String getCinstallment() {
        return cinstallment;
    }

    public void setCinstallment(String cinstallment) {
        this.cinstallment = cinstallment;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public String getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(String outstanding) {
        this.outstanding = outstanding;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
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
