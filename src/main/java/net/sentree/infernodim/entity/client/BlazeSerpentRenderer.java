package net.sentree.infernodim.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sentree.infernodim.InfernoMod;
import net.sentree.infernodim.entity.custom.BlazeSerpentEntity;

public class BlazeSerpentRenderer extends MobRenderer<BlazeSerpentEntity, BlazeSerpentModel<BlazeSerpentEntity>> {
    public BlazeSerpentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BlazeSerpentModel<>(pContext.bakeLayer(ModModelLayers.BLAZE_SERPENT_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BlazeSerpentEntity pEntity) {
        return new ResourceLocation(InfernoMod.MOD_ID, "textures/entity/blaze_serpent.png");
    }

    @Override
    public void render(BlazeSerpentEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
