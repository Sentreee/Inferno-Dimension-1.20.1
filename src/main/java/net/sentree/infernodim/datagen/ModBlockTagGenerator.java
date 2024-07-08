package net.sentree.infernodim.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, InfernoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //this.tag(ModTags.)

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.INFERNO_DEBRIS.get(),
                        ModBlocks.INFERNO_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ASH_BLOCK.get());

        //this.tag(BlockTags.NEEDS_STONE_TOOL)

        //this.tag(BlockTags.NEEDS_IRON_TOOL)

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.INFERNO_DEBRIS.get(),
                        ModBlocks.INFERNO_BLOCK.get());


    }
}
