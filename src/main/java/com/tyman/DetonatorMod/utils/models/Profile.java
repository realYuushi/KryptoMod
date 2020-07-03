package com.tyman.DetonatorMod.utils.models;

public class Profile {

    private String username;
    private String uuid;

    private long weeklyGexp;

    public Profile(String username, String uuid) {
        this.username = username;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public long getWeeklyGexp() {
        return weeklyGexp;
    }

    public void setWeeklyGexp(long weeklyGexp) {
        this.weeklyGexp = weeklyGexp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
