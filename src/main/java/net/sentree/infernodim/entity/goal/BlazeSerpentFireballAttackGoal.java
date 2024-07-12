package net.sentree.infernodim.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.sentree.infernodim.entity.custom.BlazeSerpentEntity;

import java.util.EnumSet;

public class BlazeSerpentFireballAttackGoal extends Goal {
    private final BlazeSerpentEntity blazeSerpent;
    private int attackStep;
    private int attackTime;

    public BlazeSerpentFireballAttackGoal(BlazeSerpentEntity blazeSerpent) {
        this.blazeSerpent = blazeSerpent;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.blazeSerpent.getTarget();
        return target != null && target.isAlive();
    }

    @Override
    public void start() {
        this.attackStep = 0;
    }

    @Override
    public void stop() {
        this.blazeSerpent.setAggressive(false);
        this.attackStep = 0;
    }

    @Override
    public void tick() {
        LivingEntity target = this.blazeSerpent.getTarget();
        if (target != null) {
            double distance = this.blazeSerpent.distanceToSqr(target);
            boolean canSeeTarget = this.blazeSerpent.getSensing().hasLineOfSight(target);

            if (canSeeTarget) {
                this.blazeSerpent.getLookControl().setLookAt(target, 10.0F, 10.0F);
                if (--this.attackTime <= 0) {
                    if (this.attackStep == 0) {
                        this.attackTime = 60;
                        this.attackStep++;
                    } else if (this.attackStep < 4) {
                        this.attackTime = 6;
                        this.attackStep++;
                    } else {
                        this.attackTime = 25;
                        this.attackStep = 0;
                    }

                    if (this.attackStep > 1) {
                        double dx = target.getX() - this.blazeSerpent.getX();
                        double dy = target.getY(0.5D) - (this.blazeSerpent.getY(0.5D) + 0.5D);
                        double dz = target.getZ() - this.blazeSerpent.getZ();
                        double spread = Math.sqrt(Math.sqrt(distance)) * 0.5D;
                        this.blazeSerpent.level().levelEvent(null, 1018, this.blazeSerpent.blockPosition(), 0);

                        for (int i = 0; i < 1; ++i) {
                            SmallFireball fireball = new SmallFireball(this.blazeSerpent.level(), this.blazeSerpent, dx + this.blazeSerpent.getRandom().nextGaussian() * spread, dy, dz + this.blazeSerpent.getRandom().nextGaussian() * spread);
                            fireball.setPos(fireball.getX(), this.blazeSerpent.getY(0.5D) + 0.5D, fireball.getZ());
                            this.blazeSerpent.level().addFreshEntity(fireball);
                        }
                    }
                }
            }
        }
    }
}