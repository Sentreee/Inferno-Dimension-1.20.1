package net.sentree.infernodim.entity.client;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.sentree.infernodim.entity.animations.ModAnimationDefinitions;
import net.sentree.infernodim.entity.custom.BlazeSerpentEntity;

public class BlazeSerpentModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart blaze_serpent;
	private final ModelPart head;

	public BlazeSerpentModel(ModelPart root) {
		this.blaze_serpent = root.getChild("blaze_serpent");
		this.head = blaze_serpent.getChild("neck").getChild("head").getChild("lower_jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition blaze_serpent = partdefinition.addOrReplaceChild("blaze_serpent", CubeListBuilder.create().texOffs(36, 12).addBox(-3.0F, -6.0F, 7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(18, 30).addBox(-3.0F, -11.25F, -6.25F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 48).addBox(-3.0F, -6.0F, 7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r1 = blaze_serpent.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 6).addBox(-3.0F, -6.25F, -29.75F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = blaze_serpent.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -26.0F, -23.25F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(18, 18).addBox(-3.0F, -21.25F, -17.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r3 = blaze_serpent.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -16.75F, -17.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = blaze_serpent.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 36).addBox(-3.0F, -6.0F, -13.75F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r5 = blaze_serpent.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(54, 54).addBox(-0.5F, 11.0F, -22.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r6 = blaze_serpent.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 60).addBox(-0.5F, 11.0F, -13.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r7 = blaze_serpent.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(35, 60).addBox(-0.5F, 7.0F, -5.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -2.3126F, 0.0F, 0.0F));

		PartDefinition cube_r8 = blaze_serpent.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition neck = blaze_serpent.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 21.0F));

		PartDefinition cube_r9 = neck.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(54, 18).addBox(-0.5F, -17.75F, 2.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 36).addBox(-3.0F, -18.0F, 4.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -11.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r10 = neck.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(54, 30).addBox(-0.5F, -24.75F, -5.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 24).addBox(-3.0F, -24.75F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(18, 42).addBox(-3.0F, -14.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -11.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r11 = neck.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(62, 23).addBox(-0.5F, -11.0F, -3.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -11.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r12 = neck.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 48).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -11.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition eye2_r1 = head.addOrReplaceChild("eye2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -20.75F, -23.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-2.0F, -20.75F, -23.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(49, 64).addBox(-0.5F, -20.75F, -26.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(49, 64).addBox(-1.0F, -21.75F, -24.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -11.0F, -1.3526F, 0.0F, 0.0F));

		PartDefinition upper_jaw = head.addOrReplaceChild("upper_jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, -11.0F));

		PartDefinition upper_jaw_r1 = upper_jaw.addOrReplaceChild("upper_jaw_r1", CubeListBuilder.create().texOffs(21, 57).addBox(-2.0F, -22.75F, -22.0F, 4.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3526F, 0.0F, 0.0F));

		PartDefinition lower_jaw = head.addOrReplaceChild("lower_jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition lower_jaw_r1 = lower_jaw.addOrReplaceChild("lower_jaw_r1", CubeListBuilder.create().texOffs(60, 0).addBox(-2.0F, -15.75F, -23.25F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -12.0F, -1.6581F, 0.0F, 0.0F));

		PartDefinition tail = blaze_serpent.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition bone = tail.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, -33.0F));

		PartDefinition spine7_r1 = bone.addOrReplaceChild("spine7_r1", CubeListBuilder.create().texOffs(54, 42).addBox(-0.5F, 24.0F, 20.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 33.0F, -2.6616F, 0.0F, 0.0F));

		PartDefinition tail1_r1 = bone.addOrReplaceChild("tail1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -23.0F, -30.75F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 33.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition tail2_r1 = bone2.addOrReplaceChild("tail2_r1", CubeListBuilder.create().texOffs(56, 8).addBox(-2.0F, -17.75F, -35.75F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 34.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition tail3_r1 = bone3.addOrReplaceChild("tail3_r1", CubeListBuilder.create().texOffs(62, 52).addBox(-1.0F, -24.75F, -33.75F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, 34.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition tail4_r1 = bone4.addOrReplaceChild("tail4_r1", CubeListBuilder.create().texOffs(14, 60).addBox(-0.5F, -31.75F, -31.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 34.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((BlazeSerpentEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
		this.animate(((BlazeSerpentEntity) entity).attackAnimationState, ModAnimationDefinitions.ATTACK, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		blaze_serpent.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return blaze_serpent;
	}
}