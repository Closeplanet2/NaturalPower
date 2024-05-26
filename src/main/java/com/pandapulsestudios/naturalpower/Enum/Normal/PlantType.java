package com.pandapulsestudios.naturalpower.Enum.Normal;

import org.bukkit.Material;

public enum PlantType {
    BEETROOT(Material.BEETROOT, "NaturalPower.BEETROOT"),
    CACTUS(Material.CACTUS, "NaturalPower.CACTUS"),
    CARROTS(Material.CARROTS, "NaturalPower.CARROTS"),
    CHORUS_FLOWER(Material.CHORUS_FLOWER, "NaturalPower.CHORUS_FLOWER"),
    FROSTED_ICE(Material.FROSTED_ICE, "NaturalPower.FROSTED_ICE"),
    KELP(Material.KELP, "NaturalPower.KELP"),
    MELON_STEM(Material.MELON_STEM, "NaturalPower.MELON_STEM"),
    NETHER_WART(Material.NETHER_WART, "NaturalPower.NETHER_WART"),
    POTATOES(Material.POTATOES, "NaturalPower.POTATOES"),
    PUMPKIN_STEM(Material.PUMPKIN_STEM, "NaturalPower.PUMPKIN_STEM"),
    SUGAR_CANE(Material.SUGAR_CANE, "NaturalPower.SUGAR_CANE"),
    SWEET_BERRY_BUSH(Material.SWEET_BERRY_BUSH, "NaturalPower.SWEET_BERRY_BUSH"),
    TORCHFLOWER_CROP(Material.TORCHFLOWER_CROP, "NaturalPower.TORCHFLOWER_CROP"),
    TWISTING_VINES(Material.TWISTING_VINES, "NaturalPower.TWISTING_VINES"),
    WEEPING_VINES(Material.WEEPING_VINES, "NaturalPower.WEEPING_VINES"),
    WHEAT(Material.WHEAT, "NaturalPower.WHEAT");


    public final Material type;
    public final String permission;

    PlantType(Material type, String permission){
        this.type = type;
        this.permission = permission;
    }
}
