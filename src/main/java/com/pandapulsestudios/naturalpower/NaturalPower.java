package com.pandapulsestudios.naturalpower;

import com.pandapulsestudios.naturalpower.VariableTests.MessageVariableTest;
import com.pandapulsestudios.naturalpower.VariableTests.PermissionVariableTest;
import com.pandapulsestudios.pulsecommands.PulseCommands;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulsecore.JavaAPI.API.ClassAPI;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class NaturalPower extends JavaPlugin {
    @Getter
    private static NaturalPower Instance;

    @Override
    public void onEnable() {
        Instance = this;
        ClassAPI.RegisterPulseVariableTest(new MessageVariableTest());
        ClassAPI.RegisterPulseVariableTest(new PermissionVariableTest());
        StorageAPI.RegisterStatic(this, false);
        ClassAPI.RegisterClasses(this);
        PulseCommands.RegisterRaw(this);
    }
}
