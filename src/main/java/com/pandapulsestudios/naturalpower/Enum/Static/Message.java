package com.pandapulsestudios.naturalpower.Enum.Static;

public enum Message {
    ConsoleEnabledSystem("#7fff36System has been enabled!"),
    ConsoleDisableSystem("#fa3448System has been disabled!"),
    PlayerReloadedConfig("#7fff36You have reloaded the configs!"),
    PlayerResetConfig("#7fff36You have reset the configs!"),
    GrowingCrops("#7fff36Growing Crops In the area");

    public final String message;
    Message(String message){
        this.message = message;
    }
}
