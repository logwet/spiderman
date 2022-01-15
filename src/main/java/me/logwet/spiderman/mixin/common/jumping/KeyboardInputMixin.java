package me.logwet.spiderman.mixin.common.jumping;

import net.minecraft.client.player.Input;
import net.minecraft.client.player.KeyboardInput;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin extends Input {
    @Redirect(
            method = "tick",
            at =
                    @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/client/player/KeyboardInput;jumping:Z",
                            opcode = Opcodes.PUTFIELD))
    private void overrideJumpKey(KeyboardInput keyboardInput, boolean value) {
        keyboardInput.jumping = false;
    }
}
