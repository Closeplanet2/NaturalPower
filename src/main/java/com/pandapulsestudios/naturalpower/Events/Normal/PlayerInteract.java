package com.pandapulsestudios.naturalpower.Events.Normal;

import com.pandapulsestudios.naturalpower.API.GrowCropsAPI;
import com.pandapulsestudios.naturalpower.Enum.Static.Permission;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.NaturalPowerPlugin;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.RaycastAPI.API.RaycastAPI;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Set;

@PulseAutoRegister
public class PlayerInteract implements Listener {

    public static final Set<Material> IGNORE_MATERIALS_START = new HashSet<>();
    static {
        IGNORE_MATERIALS_START.add(Material.AIR);
        IGNORE_MATERIALS_START.add(Material.BARRIER);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        var player = event.getPlayer();
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.GROW_CROPS, player, false)) return;
        if(!player.isSneaking() || !NaturalPowerPlugin.ReturnStatic().systemEnabled) return;
        var radius = NaturalPowerPlugin.ReturnStatic().sneakRadius;
        GrowCropsAPI.GrowCrops(player, event.getClickedBlock().getLocation(), radius, 1);
    }
}
