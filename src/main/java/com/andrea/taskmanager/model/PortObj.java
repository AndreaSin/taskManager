package com.andrea.taskmanager.model;

public class PortObj {
    String proto;
    String localAddress;
    String extAddress;
    String status;

    public PortObj(String proto, String localAddress, String extAddress, String status) {
        this.proto = proto;
        this.localAddress = localAddress;
        this.extAddress = extAddress;
        this.status = status;
    }

    public PortObj() {
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
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