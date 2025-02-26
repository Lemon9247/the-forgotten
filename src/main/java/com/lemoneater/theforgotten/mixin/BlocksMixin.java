package com.lemoneater.theforgotten.mixin;

import net.minecraft.server.MinecraftServer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Blocks.class)
public class BlocksMixin {

    @Redirect(
    
    // The MIT License (MIT)
    // 
    // Copyright (c) 2020-2023 Xanthian
    // 
    // Permission is hereby granted, free of charge, to any person obtaining a copy
    // of this software and associated documentation files (the "Software"), to deal
    // in the Software without restriction, including without limitation the rights
    // to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    // copies of the Software, and to permit persons to whom the Software is
    // furnished to do so, subject to the following conditions:
    // 
    // The above copyright notice and this permission notice shall be included in
    // all copies or substantial portions of the Software.
    // 
    // THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    // IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    // FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    // AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    // LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    // OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    // THE SOFTWARE.
    /**
     * @author Xanthian
     **/
    
    method = "<clinit>",
    slice = @Slice(
        from = @At(
            value = "CONSTANT",
            args = "stringValue=reinforced_deepslate")),
    at = @At(
        value = "INVOKE",
        target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;",
        ordinal = 0))

    private static AbstractBlock.Settings rfdsm$redirectRequiresTool(AbstractBlock.Settings settings, float hardness, float resistance) {
        return settings
            .mapColor(MapColor.DEEPSLATE_GRAY)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sounds(BlockSoundGroup.DEEPSLATE)
            .requiresTool()
            .strength(50.0f, 1200.0f);
    }
}