package com.pandapulsestudios.naturalpower.API;

import com.pandapulsestudios.naturalpower.Enum.Normal.PlantType;
import com.pandapulsestudios.naturalpower.Enum.Static.Message;
import com.pandapulsestudios.naturalpower.Events.Custom.PlayerGrowCropsEvent;
import com.pandapulsestudios.naturalpower.PulseConfigs.Static.Messages;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class GrowCropsAPI {
    public static void GrowCrops(Player player, Location location, int radius, int ageAmount, PlantType... plantTypes){
        var plantTypeList = Arrays.stream(plantTypes).toList();
        for(var x = location.getX() - radius; x < location.getX() + radius; x++){
            for(var y = location.getY() - radius; y < location.getY() + radius; y++){
                for(var z = location.getZ() - radius; z < location.getZ() + radius; z++){
                    var newLocation = new Location(location.getWorld(), x, y, z);
                    var checkBlock = newLocation.getBlock();
                    if(!plantTypeList.isEmpty() && !DoesContainAndPlayerHasPermission(player, checkBlock.getType(), plantTypeList)) continue;
                    var checkBlockData = checkBlock.getBlockData();
                    if(checkBlockData instanceof Ageable ageable){
                        var event = new PlayerGrowCropsEvent(player, plantTypes);
                        if(event.isCancelled()) return;

                        var current = ageable.getAge();
                        var next = Math.min(ageable.getAge() + ageAmount, ageable.getMaximumAge());
                        ageable.setAge(next);
                        if(next > current) Messages.ReturnStatic().SendMessageToPlayer(Message.GrowingCrops, player);
                    }
                    checkBlock.setBlockData(checkBlockData);

                }
            }
        }
    }

    private static boolean DoesContainAndPlayerHasPermission(Player player, Material material, List<PlantType> plantTypes){
        if(plantTypes.isEmpty()) return true;
        for(var plantType : plantTypes) {
            if (player == null && plantType.type == material) return true;
            else if (player != null && player.hasPermission(plantType.permission) && plantType.type == material) return true;
        }
        return false;
    }
}
