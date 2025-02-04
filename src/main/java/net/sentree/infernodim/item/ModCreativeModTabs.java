package net.sentree.infernodim.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InfernoMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("inferno_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INFERNO_INGOT.get()))
                    .title(Component.translatable("creativetab.inferno_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.INFERNO_INGOT.get());
                        pOutput.accept(ModItems.INFERNO_SCRAP.get());
                        pOutput.accept(ModItems.YORKSHIRE_GOLD_TEA.get());
                        pOutput.accept(ModItems.BLAZE_SERPENT_SPAWN_EGG.get());

                        pOutput.accept(ModBlocks.INFERNO_DEBRIS.get());
                        pOutput.accept(ModBlocks.INFERNO_BLOCK.get());
                        pOutput.accept(ModBlocks.ASH_BLOCK.get());
                        pOutput.accept(ModBlocks.INFERNO_PORTAL.get());
                        pOutput.accept(ModBlocks.HARDENED_ASH_BLOCK.get());

                        pOutput.accept(ModBlocks.BLAZE_PLANKS.get());
                        pOutput.accept(ModBlocks.BLAZE_SAPLING.get());
                        pOutput.accept(ModBlocks.BLAZE_LOG.get());
                        pOutput.accept(ModBlocks.BLAZE_WOOD.get());
                        pOutput.accept(ModBlocks.BLAZE_LEAVES.get());
                        pOutput.accept(ModBlocks.BLAZE_PLANKS.get());
                        pOutput.accept(ModBlocks.STRIPPED_BLAZE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_BLAZE_WOOD.get());




                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
