package org.purpurmc.purpur.client.mixin.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.world.World;
import org.purpurmc.purpur.client.entity.RidableEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SkeletonEntity.class)
public abstract class MixinSkeleton extends MobEntity implements RidableEntity {
    public MixinSkeleton(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public double getMountedHeightOffset() {
        return (double) getHeight() * getSeats().skeleton.y;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        updatePassengerPosition(passenger, getSeats().skeleton);
    }
}
