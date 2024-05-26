package com.pandapulsestudios.naturalpower.PulseCommands;

import com.pandapulsestudios.api.Enum.TabType;
import com.pandapulsestudios.api.Interface.*;
import com.pandapulsestudios.naturalpower.API.GrowCropsAPI;
import com.pandapulsestudios.naturalpower.API.NaturalPowerAPI;
import com.pandapulsestudios.naturalpower.Enum.Normal.PlantType;
import com.pandapulsestudios.naturalpower.Enum.Static.Message;
import com.pandapulsestudios.naturalpower.Enum.Static.Permission;
import com.pandapulsestudios.naturalpower.NaturalPower;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.Messages;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.NaturalPowerPlugin;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulsecommands.PlayerCommand;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.VariableAPI.API.VariableAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@PulseAutoRegister
public class NaturalPowerCommands extends PlayerCommand {
    public NaturalPowerCommands() {
        super(NaturalPower.getInstance(), "npower", false);
    }

    @Override
    public void NoMethodFound(Player player, String s, String[] strings) {}

    @Override
    public String helpMenuPrefix(Player player) { return "#4254f5[#4298f5Natural Power Commands#4254f5]#68ed90"; }

    @Override
    public LinkedHashMap<String, String> helpMenuFormat(Player player, LinkedHashMap<String, String> linkedHashMap) {
        var data = new LinkedHashMap<String, String>();
        for(var key : linkedHashMap.keySet()) data.put("#28bf56" + key, "#28bf56" + linkedHashMap.get(key));
        return data;
    }

    @Override
    public String helpMenuSuffix(Player player) { return "#4254f5============"; }

    @PCMethod
    @PCSignature({"enable"})
    @PCAutoTab(pos = 1)
    public void EnableSystem(CraftPlayer craftPlayer, boolean state){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.ENABLE_SYSTEM, craftPlayer, true)) return;
        NaturalPowerAPI.EnableSystem(state);
        if(craftPlayer != null) Messages.ReturnStatic().SendMessageToPlayer(state ? Message.ConsoleEnabledSystem : Message.ConsoleDisableSystem, craftPlayer);
    }

    @PCMethod
    @PCSignature({"configs", "reset"})
    public void ResetConfigs(CraftPlayer admin){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.RESET_CONFIGS, admin, true)) return;
        if(!NaturalPowerPlugin.ReturnStatic().systemEnabled) return;
        Messages.ReturnStatic().SendMessageToPlayer(Message.PlayerResetConfig, admin);
    }

    @PCMethod
    @PCSignature({"configs", "reload"})
    public void ReloadConfigs(CraftPlayer admin){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.RELOAD_CONFIGS, admin, true)) return;
        if(!NaturalPowerPlugin.ReturnStatic().systemEnabled) return;
        NaturalPowerAPI.ReloadConfigs();
        Messages.ReturnStatic().SendMessageToPlayer(Message.PlayerReloadedConfig, admin);
    }

    @PCMethod
    @PCSignature({"grow"})
    @PCTab(pos = 1, type = TabType.Pure_Data, data = "[RADIUS]")
    public void GrowCrops(CraftPlayer craftPlayer, int radius){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.GROW_CROPS, craftPlayer, true)) return;
        if(!NaturalPowerPlugin.ReturnStatic().systemEnabled) return;
        GrowCropsAPI.GrowCrops(craftPlayer, craftPlayer.getLocation(), radius, 1);
    }

    @PCMethod
    @PCSignature({"grow"})
    @PCTab(pos = 1, type = TabType.Pure_Data, data = "[RADIUS]")
    @PCAutoTab(pos = 2)
    public void GrowCrops(CraftPlayer craftPlayer, int radius, PlantType plantType){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.GROW_CROPS, craftPlayer, true)) return;
        if(!NaturalPowerPlugin.ReturnStatic().systemEnabled) return;
        GrowCropsAPI.GrowCrops(craftPlayer, craftPlayer.getLocation(), radius, 1, plantType);
    }
}
