package com.pandapulsestudios.naturalpower.Events.Normal;

import com.pandapulsestudios.naturalpower.API.GrowCropsAPI;
import com.pandapulsestudios.naturalpower.Enum.Static.Permission;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.NaturalPowerPlugin;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

@PulseAutoRegister
public class PlayerSneak implements Listener {

    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event){
        var player = event.getPlayer();
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.GROW_CROPS, player, false)) return;
        if(!player.isSneaking() || !NaturalPowerPlugin.ReturnStatic().systemEnabled) return;
        var radius = NaturalPowerPlugin.ReturnStatic().sneakRadius;
        GrowCropsAPI.GrowCrops(player, player.getLocation(), radius, 1);
    }

}
