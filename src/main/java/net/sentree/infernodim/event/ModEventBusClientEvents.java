package net.sentree.infernodim.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.entity.client.BlazeSerpentModel;
import net.sentree.infernodim.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = InfernoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.BLAZE_SERPENT_LAYER, BlazeSerpentModel::createBodyLayer);
    }

}
