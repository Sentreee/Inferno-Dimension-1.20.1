package net.sentree.infernodim.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.sentree.infernodim.InfernoMod;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(InfernoMod.MOD_ID, "overworld"), 5));
    }
}
