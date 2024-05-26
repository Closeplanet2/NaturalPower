package com.pandapulsestudios.naturalpower.PulseConfigs.Static;

import com.pandapulsestudios.naturalpower.Events.Custom.EnableSystemEvent;
import com.pandapulsestudios.naturalpower.NaturalPower;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;
import com.pandapulsestudios.pulseconfig.Interface.PulseConfig;
import com.pandapulsestudios.pulseconfig.Interface.StorageComment;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class NaturalPowerPlugin implements PulseConfig {
    public static NaturalPowerPlugin ReturnStatic(){
        var stored = StorageAPI.ReturnStatic(NaturalPowerPlugin.class, StorageType.CONFIG, false);
        return stored == null ? new NaturalPowerPlugin() : (NaturalPowerPlugin) stored;
    }

    @Override
    public JavaPlugin mainClass() {return NaturalPower.getInstance();}

    @StorageComment("WARNING: SYSTEM WONT RUN IF FALSE!")
    public boolean systemEnabled = true;
    public boolean debugConfig = false;
    public int sneakRadius = 3;

    public void ToggleSystemEnabled(boolean newState){
        new EnableSystemEvent(systemEnabled, newState);
        systemEnabled = newState;
        SaveConfig(false);
    }
}
