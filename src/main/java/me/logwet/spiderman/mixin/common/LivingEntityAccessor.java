package me.logwet.spiderman.mixin.common;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {
    @Accessor("lastClimbablePos")
    void setLastClimbablePos(
            @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
                    Optional<BlockPos> lastClimbablePos);
}
