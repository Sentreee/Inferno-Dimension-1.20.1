package net.sentree.infernodim.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.entity.custom.BlazeSerpentEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>>  ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, InfernoMod.MOD_ID);

    public static final RegistryObject<EntityType<BlazeSerpentEntity>> BLAZE_SERPENT =
            ENTITY_TYPES.register("blaze_serpent", () -> EntityType.Builder.of(BlazeSerpentEntity::new, MobCategory.MONSTER)
                    .sized(1.5f,1.5f).build("blaze_serpent"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
