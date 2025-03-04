package org.purpurmc.purpur.client.mixin.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.purpurmc.purpur.client.entity.RidableEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GhastEntity.class)
public abstract class MixinGhast extends MobEntity implements RidableEntity {
    public MixinGhast(EntityType<? extends GhastEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public double getMountedHeightOffset() {
        return (double) getHeight() * getSeats().ghast.y;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        updatePassengerPosition(passenger, getSeats().ghast);
    }
}
