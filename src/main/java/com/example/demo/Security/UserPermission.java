package com.example.demo.Security;

public enum UserPermission {
    
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    RENDEZVOUS_READ("rendez_vous:read"),
    RENDEZVOUS_WRITE("rendez_vous:write");

    private final String permession;

    public String getPermession() {
        return permession;
    }

    private UserPermission(String permession) {
        this.permession = permession;
    }
}
