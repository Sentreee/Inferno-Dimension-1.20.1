package net.sentree.infernodim.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.entity.ModEntities;
import net.sentree.infernodim.entity.custom.BlazeSerpentEntity;

@Mod.EventBusSubscriber(modid = InfernoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BLAZE_SERPENT.get(), BlazeSerpentEntity.createAttributes().build());
    }
}
