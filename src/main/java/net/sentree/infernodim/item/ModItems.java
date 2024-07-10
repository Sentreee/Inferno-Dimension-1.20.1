package net.sentree.infernodim.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.infernodim.InfernoMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InfernoMod.MOD_ID);

    public static final RegistryObject<Item> INFERNO_SCRAP = ITEMS.register("inferno_scrap",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INFERNO_INGOT = ITEMS.register("inferno_ingot",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> YORKSHIRE_GOLD_TEA = ITEMS.register("yorkshire_gold_tea",
            () -> new Item(new Item.Properties().food(ModFoods.YORKSHIRE_GOLD_TEA)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
