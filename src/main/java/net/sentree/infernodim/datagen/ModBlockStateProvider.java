package net.sentree.infernodim.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, InfernoMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.INFERNO_BLOCK);
        blockWithItem(ModBlocks.INFERNO_DEBRIS);
        blockWithItem(ModBlocks.ASH_BLOCK);
        blockWithItem(ModBlocks.INFERNO_PORTAL);
        blockWithItem(ModBlocks.HARDENED_ASH_BLOCK);

        saplingBlock(ModBlocks.BLAZE_SAPLING);



        logBlock(((RotatedPillarBlock) ModBlocks.BLAZE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BLAZE_WOOD.get()), blockTexture(ModBlocks.BLAZE_LOG.get()), blockTexture(ModBlocks.BLAZE_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLAZE_LOG.get()), blockTexture(ModBlocks.STRIPPED_BLAZE_LOG.get()),
                new ResourceLocation(InfernoMod.MOD_ID, "block/stripped_blaze_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLAZE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BLAZE_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_BLAZE_LOG.get()));

        blockItem(ModBlocks.BLAZE_LOG);
        blockItem(ModBlocks.BLAZE_WOOD);
        blockItem(ModBlocks.STRIPPED_BLAZE_LOG);
        blockItem(ModBlocks.STRIPPED_BLAZE_WOOD);

        blockWithItem(ModBlocks.BLAZE_PLANKS);

        leavesBlock(ModBlocks.BLAZE_LEAVES);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(InfernoMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
