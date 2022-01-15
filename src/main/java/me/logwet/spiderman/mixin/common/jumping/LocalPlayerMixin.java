package me.logwet.spiderman.mixin.common.jumping;

import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {
    @Redirect(
            method = "aiStep",
            at =
                    @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/client/player/Input;jumping:Z",
                            opcode = Opcodes.PUTFIELD))
    private void preventAutoJump(Input input, boolean value) {
        input.jumping = false;
    }
}
