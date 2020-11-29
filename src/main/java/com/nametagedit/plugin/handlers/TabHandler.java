package com.nametagedit.plugin.handlers;

public abstract class TabHandler
{
    private String members;
    private String prefix;
    private String suffix;
    private String teamName;
    private String paramInt;
    private String packOption;
    private String displayName;
    private String color;
    private String push;
    private String visibility;
    
    public TabHandler(final String members, final String prefix, final String suffix, final String teamName, final String paramInt, final String packOption, final String displayName, final String color, final String push, final String visibility) {
        this.members = members;
        this.prefix = prefix;
        this.suffix = suffix;
        this.teamName = teamName;
        this.paramInt = paramInt;
        this.packOption = packOption;
        this.displayName = displayName;
        this.color = color;
        this.push = push;
        this.visibility = visibility;
    }
    
    public abstract String formatTeamName(final String p0);
    
    public abstract String format(final String p0, final boolean p1);
    
    public String getMembers() {
        return this.members;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public String getTeamName() {
        return this.teamName;
    }
    
    public String getParamInt() {
        return this.paramInt;
    }
    
    public String getPackOption() {
        return this.packOption;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String getPush() {
        return this.push;
    }
    
    public String getVisibility() {
        return this.visibility;
    }
}
