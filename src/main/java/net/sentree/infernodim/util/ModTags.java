package net.sentree.infernodim.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block ;
import net.sentree.infernodim.InfernoMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ASH_BLOCK_REPLACEABLES = tag("ash_block_replaceables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(InfernoMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(InfernoMod.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_INFERNO = tag("is_inferno");



        private static TagKey<Biome> tag(String pName) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(InfernoMod.MOD_ID, pName));
        }
    }
}
