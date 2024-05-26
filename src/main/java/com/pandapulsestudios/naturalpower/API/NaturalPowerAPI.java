package com.pandapulsestudios.naturalpower.API;

import com.pandapulsestudios.naturalpower.Events.Custom.ReloadConfigEvent;
import com.pandapulsestudios.naturalpower.Events.Custom.ResetConfigEvent;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.Messages;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.NaturalPowerPlugin;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;

public class NaturalPowerAPI {
    public static void EnableSystem(boolean state){
        NaturalPowerPlugin.ReturnStatic().ToggleSystemEnabled(state);
    }

    public static void ResetConfigs(){
        StorageAPI.ResetStatic(Messages.class, StorageType.CONFIG, false, Messages.ReturnStatic().debugConfig);
        StorageAPI.ResetStatic(Permissions.class, StorageType.CONFIG, false, Permissions.ReturnStatic().debugConfig);
        StorageAPI.ResetStatic(NaturalPowerPlugin.class, StorageType.CONFIG, false, NaturalPowerPlugin.ReturnStatic().debugConfig);
        new ResetConfigEvent();
    }

    public static void ReloadConfigs(){
        StorageAPI.ReloadStatic(Messages.class, StorageType.CONFIG, false, Messages.ReturnStatic().debugConfig);
        StorageAPI.ReloadStatic(Permissions.class, StorageType.CONFIG, false, Permissions.ReturnStatic().debugConfig);
        StorageAPI.ReloadStatic(NaturalPowerPlugin.class, StorageType.CONFIG, false, NaturalPowerPlugin.ReturnStatic().debugConfig);
        new ReloadConfigEvent();
    }

}
