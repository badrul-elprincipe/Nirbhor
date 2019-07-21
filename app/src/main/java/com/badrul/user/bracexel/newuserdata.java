package com.badrul.user.bracexel;

public class newuserdata {
    private String name;
    private int yincome;
    private String ploanrecord;
    private int fmember;
    private String character;
    private String criminalrec;
    private String popinion;

    public newuserdata (String name,int yincome,String ploanrecord,int fmember,String character,String criminalrec,String popinion){
        this.name=name;
        this.yincome=yincome;
        this.ploanrecord=ploanrecord;
        this.fmember=fmember;
        this.character=character;
        this.criminalrec=criminalrec;
        this.popinion=popinion;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYincome() {
        return yincome;
    }

    public void setYincome(int yincome) {
        this.yincome = yincome;
    }

    public String getPloanrecord() {
        return ploanrecord;
    }

    public void setPloanrecord(String ploanrecord) {
        this.ploanrecord = ploanrecord;
    }

    public int getFmember() {
        return fmember;
    }

    public void setFmember(int fmember) {
        this.fmember = fmember;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCriminalrec() {
        return criminalrec;
    }

    public void setCriminalrec(String criminalrec) {
        this.criminalrec = criminalrec;
    }

    public String getPopinion() {
        return popinion;
    }

    public void setPopinion(String popinion) {
        this.popinion = popinion;
    }
}
