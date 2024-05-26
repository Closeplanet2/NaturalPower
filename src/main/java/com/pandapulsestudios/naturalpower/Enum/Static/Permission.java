package com.pandapulsestudios.naturalpower.Enum.Static;

public enum Permission {
    RELOAD_CONFIGS("NaturalPower.RELOAD_CONFIGS", "#fa3448You do not have the permissions to use this command!"),
    RESET_CONFIGS("NaturalPower.RESET_CONFIGS", "#fa3448You do not have the permissions to use this command!"),
    ENABLE_SYSTEM("NaturalPower.ENABLE_SYSTEM", "#fa3448You do not have the permissions to use this command!"),
    GROW_CROPS("NaturalPower.GROW_CROPS", "#fa3448You do not have the permissions to use this command!");

    public final String permission;
    public final String error;
    Permission(String permission, String error){
        this.permission = permission;
        this.error = error;
    }
}
