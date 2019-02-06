package com.andrea.taskmanager.model;

public class ProcessObj {
    
    String nomeImmagine;
    String pid;
    String nomeSessione;
    String numSessione;
    String memUse;

    public ProcessObj(String nomeImmagine, String pid, String nomeSessione, String numSessione, String memUse) {
        this.nomeImmagine = nomeImmagine;
        this.pid = pid;
        this.nomeSessione = nomeSessione;
        this.numSessione = numSessione;
        this.memUse = memUse;
    }

    public ProcessObj() {
    }

    public String getNomeImmagine() {
        return nomeImmagine;
    }

    public void setNomeImmagine(String nomeImmagine) {
        this.nomeImmagine = nomeImmagine;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNomeSessione() {
        return nomeSessione;
    }

    public void setNomeSessione(String nomeSessione) {
        this.nomeSessione = nomeSessione;
    }

    public String getNumSessione() {
        return numSessione;
    }

    public void setNumSessione(String numSessione) {
        this.numSessione = numSessione;
    }

    public String getMemUse() {
        return memUse;
    }

    public void setMemUse(String memUse) {
        this.memUse = memUse;
    }

}