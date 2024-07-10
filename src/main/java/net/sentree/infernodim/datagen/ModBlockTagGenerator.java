package net.sentree.infernodim.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.block.ModBlocks;
import net.sentree.infernodim.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, InfernoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.ASH_BLOCK_REPLACEABLES)
                .add(ModBlocks.HARDENED_ASH_BLOCK.get())
                .add(ModBlocks.ASH_BLOCK.get());



        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.INFERNO_DEBRIS.get(),
                        ModBlocks.INFERNO_BLOCK.get(),
                        ModBlocks.HARDENED_ASH_BLOCK.get(),
                        ModBlocks.INFERNO_PORTAL.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ASH_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BLAZE_LOG.get(),
                        ModBlocks.BLAZE_PLANKS.get(),
                        ModBlocks.BLAZE_WOOD.get(),
                        ModBlocks.STRIPPED_BLAZE_WOOD.get(),
                        ModBlocks.STRIPPED_BLAZE_LOG.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.BLAZE_PLANKS.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BLAZE_WOOD.get(),
                        ModBlocks.BLAZE_PLANKS.get(),
                        ModBlocks.BLAZE_LOG.get(),
                        ModBlocks.STRIPPED_BLAZE_WOOD.get(),
                        ModBlocks.HARDENED_ASH_BLOCK.get(),
                        ModBlocks.STRIPPED_BLAZE_LOG.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.INFERNO_PORTAL.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.INFERNO_DEBRIS.get(),
                        ModBlocks.INFERNO_BLOCK.get());


    }
}
