package com.carlschierig.rudimentary.mixin;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateBaseMixin {
    @Shadow public abstract boolean is(TagKey<Block> block);

    @Inject(method = "requiresCorrectToolForDrops", at = @At("HEAD"), cancellable = true)
    private void requiresCorrectToolForDrops(CallbackInfoReturnable<Boolean> cir) {
        if (is(BlockTags.LOGS)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
