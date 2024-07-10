package net.sentree.infernodim.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties YORKSHIRE_GOLD_TEA = new FoodProperties.Builder()
            .fast()
            .nutrition(10)
            .saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED,100000,3), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,100000,3), 1f).build();
}
