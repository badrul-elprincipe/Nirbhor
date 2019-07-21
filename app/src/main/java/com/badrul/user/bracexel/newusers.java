package com.badrul.user.bracexel;

public class newusers {
    String id;
    String name;
    String yincome;
    String ploanrecord;
    String fmember;
    String character;
    String criminalrec;
    String popinion;

    public newusers(){

    }

    newusers (String id,String name,String yincome,String ploanrecord,String fmember,String character,String criminalrec,String popinion){
        this.id=id;
        this.name=name;
        this.yincome=yincome;
        this.ploanrecord=ploanrecord;
        this.fmember=fmember;
        this.character=character;
        this.criminalrec=criminalrec;
        this.popinion=popinion;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYincome() {
        return yincome;
    }

    public void setYincome(String yincome) {
        this.yincome = yincome;
    }

    public String getPloanrecord() {
        return ploanrecord;
    }

    public void setPloanrecord(String ploanrecord) {
        this.ploanrecord = ploanrecord;
    }

    public String getFmember() {
        return fmember;
    }

    public void setFmember(String fmember) {
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
