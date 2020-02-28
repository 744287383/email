package com.example.email.entity;

public class Users {
    private String username;

    private String pwdhash;

    private String pwdalgorithm;

    private Short useforwarding;

    private String forwarddestination;

    private Short usealias;

    private String alias;

    public Users(String username, String pwdhash, String pwdalgorithm, Short useforwarding, String forwarddestination, Short usealias, String alias) {
        this.username = username;
        this.pwdhash = pwdhash;
        this.pwdalgorithm = pwdalgorithm;
        this.useforwarding = useforwarding;
        this.forwarddestination = forwarddestination;
        this.usealias = usealias;
        this.alias = alias;
    }

    public Users() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwdhash() {
        return pwdhash;
    }

    public void setPwdhash(String pwdhash) {
        this.pwdhash = pwdhash == null ? null : pwdhash.trim();
    }

    public String getPwdalgorithm() {
        return pwdalgorithm;
    }

    public void setPwdalgorithm(String pwdalgorithm) {
        this.pwdalgorithm = pwdalgorithm == null ? null : pwdalgorithm.trim();
    }

    public Short getUseforwarding() {
        return useforwarding;
    }

    public void setUseforwarding(Short useforwarding) {
        this.useforwarding = useforwarding;
    }

    public String getForwarddestination() {
        return forwarddestination;
    }

    public void setForwarddestination(String forwarddestination) {
        this.forwarddestination = forwarddestination == null ? null : forwarddestination.trim();
    }

    public Short getUsealias() {
        return usealias;
    }

    public void setUsealias(Short usealias) {
        this.usealias = usealias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", pwdhash=").append(pwdhash);
        sb.append(", pwdalgorithm=").append(pwdalgorithm);
        sb.append(", useforwarding=").append(useforwarding);
        sb.append(", forwarddestination=").append(forwarddestination);
        sb.append(", usealias=").append(usealias);
        sb.append(", alias=").append(alias);
        sb.append("]");
        return sb.toString();
    }
}