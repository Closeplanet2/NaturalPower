package com.pandapulsestudios.naturalpower.Events.Custom;

import com.pandapulsestudios.naturalpower.Enum.Normal.PlantType;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class PlayerGrowCropsEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final PlantType[] plantType;

    public PlayerGrowCropsEvent(Player player, PlantType... plantType){
        this.player = player;
        this.plantType = plantType;
        Bukkit.getPluginManager().callEvent(this);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
