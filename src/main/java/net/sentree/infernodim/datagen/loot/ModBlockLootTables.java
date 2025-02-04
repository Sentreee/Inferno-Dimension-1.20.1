package net.sentree.infernodim.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.infernodim.block.ModBlocks;
import net.sentree.infernodim.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.INFERNO_BLOCK.get());
        this.dropSelf(ModBlocks.INFERNO_DEBRIS.get());
        this.dropSelf(ModBlocks.ASH_BLOCK.get());
        this.dropSelf(ModBlocks.HARDENED_ASH_BLOCK.get());
        this.dropSelf(ModBlocks.BLAZE_LOG.get());
        this.dropSelf(ModBlocks.BLAZE_WOOD.get());
        this.dropSelf(ModBlocks.BLAZE_PLANKS.get());
        this.dropSelf(ModBlocks.BLAZE_SAPLING.get());
        this.dropSelf(ModBlocks.STRIPPED_BLAZE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_BLAZE_WOOD.get());

        this.add(ModBlocks.BLAZE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.BLAZE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }

    protected LootTable.Builder createAncientDebrisLikeDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
