package com.andrea.taskmanager.model;

public class PortObj {
    String prot;
    String localAddress;
    String extAddress;
    String status;

    public PortObj(String prot, String localAddress, String extAddress, String status) {
        this.prot = prot;
        this.localAddress = localAddress;
        this.extAddress = extAddress;
        this.status = status;
    }

    public PortObj() {
    }

    public String getProt() {
        return prot;
    }

    public void setProt(String prot) {
        this.prot = prot;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getExtAddress() {
        return extAddress;
    }

    public void setExtAddress(String extAddress) {
        this.extAddress = extAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}