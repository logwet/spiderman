package me.logwet.spiderman.mixin.common.climbing;

import java.util.Optional;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean onClimbable() {
        boolean b = super.onClimbable();

        if (!b) {
            if (this.horizontalCollision) {
                ((LivingEntityAccessor) this)
                        .setLastClimbablePos(Optional.of(this.blockPosition()));
                return true;
            }
        }

        return b;
    }
}
