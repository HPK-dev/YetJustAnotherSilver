/*
 *     Copyright (C) 2024 HPK-dev
 *     Copyright (C) 2024 Mike Tang
 *     Copyright (C) 2024 iceice666
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package team.hpk.yjas.datagen

//? if >=26.2 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.LEGACY_SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.LEGACY_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS
import java.util.concurrent.CompletableFuture

class Block(output: FabricPackOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.BlockTagsProvider(output, completableFuture) {

    override fun addTags(arg: HolderLookup.Provider) {
        builder(ORES).addTag(SILVER_ORES)
        builder(SILVER_ORES).add(ModBlocks.DEEPSLATE_SILVER_ORE_ID, ModBlocks.SILVER_ORE_ID)
        builder(LEGACY_SILVER_ORES).addTag(SILVER_ORES)
        builder(STORAGE_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        builder(SILVER_STORAGE_BLOCKS).add(ModBlocks.SILVER_BLOCK_ID)
        builder(LEGACY_SILVER_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        builder(ORES_IN_GROUND_DEEPSLATE).add(ModBlocks.DEEPSLATE_SILVER_ORE_ID)
        builder(ORES_IN_GROUND_STONE).add(ModBlocks.SILVER_ORE_ID)
        builder(BlockTags.MINEABLE_WITH_PICKAXE).addTag(SILVER_ORES).addTag(SILVER_STORAGE_BLOCKS)
        builder(BlockTags.NEEDS_IRON_TOOL).addTag(SILVER_ORES).addTag(SILVER_STORAGE_BLOCKS)
    }
}
//?} else if >=26.1 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.LEGACY_SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.LEGACY_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS
import java.util.concurrent.CompletableFuture

class Block(output: FabricPackOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.BlockTagsProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        valueLookupBuilder(ORES).addTag(SILVER_ORES)
        valueLookupBuilder(SILVER_ORES).add(ModBlocks.DEEPSLATE_SILVER_ORE).add(ModBlocks.SILVER_ORE)
        valueLookupBuilder(LEGACY_SILVER_ORES).addTag(SILVER_ORES)
        valueLookupBuilder(STORAGE_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(SILVER_STORAGE_BLOCKS).add(ModBlocks.SILVER_BLOCK)
        valueLookupBuilder(LEGACY_SILVER_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModBlocks.DEEPSLATE_SILVER_ORE)
        valueLookupBuilder(ORES_IN_GROUND_STONE).add(ModBlocks.SILVER_ORE)
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE).addTag(SILVER_ORES).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL).addTag(SILVER_ORES).addTag(SILVER_STORAGE_BLOCKS)
    }
}
*///?} else if >=1.21.11 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.LEGACY_SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.LEGACY_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS
import java.util.concurrent.CompletableFuture

class Block(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        valueLookupBuilder(ORES).addTag(SILVER_ORES)
        valueLookupBuilder(SILVER_ORES).add(ModBlocks.DEEPSLATE_SILVER_ORE).add(ModBlocks.SILVER_ORE)
        valueLookupBuilder(LEGACY_SILVER_ORES).addTag(SILVER_ORES)
        valueLookupBuilder(STORAGE_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(SILVER_STORAGE_BLOCKS).add(ModBlocks.SILVER_BLOCK)
        valueLookupBuilder(LEGACY_SILVER_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModBlocks.DEEPSLATE_SILVER_ORE)
        valueLookupBuilder(ORES_IN_GROUND_STONE).add(ModBlocks.SILVER_ORE)
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE).addTag(SILVER_ORES).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL).addTag(SILVER_ORES).addTag(SILVER_STORAGE_BLOCKS)
    }
}
*///?} else if >=1.21.6 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import java.util.concurrent.CompletableFuture

open class Block(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        valueLookupBuilder(ORES).addTag(SILVER_ORES)
        valueLookupBuilder(SILVER_ORES).add(ModBlocks.DEEPSLATE_SILVER_ORE).add(ModBlocks.SILVER_ORE)
        valueLookupBuilder(SILVER_BLOCKS).add(ModBlocks.SILVER_BLOCK)
        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModBlocks.DEEPSLATE_SILVER_ORE)
        valueLookupBuilder(ORES_IN_GROUND_STONE).add(ModBlocks.SILVER_ORE)
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
    }
}
*///?} else if >=1.21.4 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS_SILVER
import java.util.concurrent.CompletableFuture

open class Block(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        tag(ORES).addTag(ORES_SILVER)
        tag(ORES_SILVER).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE).orElseThrow()).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE).orElseThrow())
        tag(SILVER_ORES).addTag(ORES_SILVER)
        tag(STORAGE_BLOCKS).addTag(STORAGE_BLOCKS_SILVER)
        tag(STORAGE_BLOCKS_SILVER).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_BLOCK).orElseThrow())
        tag(SILVER_BLOCKS).addTag(STORAGE_BLOCKS_SILVER)
        tag(ORES_IN_GROUND_DEEPSLATE).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE).orElseThrow())
        tag(ORES_IN_GROUND_STONE).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE).orElseThrow())
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(ORES_SILVER).addTag(STORAGE_BLOCKS_SILVER)
        tag(BlockTags.NEEDS_IRON_TOOL).addTag(ORES_SILVER).addTag(STORAGE_BLOCKS_SILVER)
    }
}
*///?} else if >=1.20 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import java.util.concurrent.CompletableFuture

open class Block(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        tag(ORES).addTag(SILVER_ORES)
        tag(SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE).orElseThrow()).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE).orElseThrow())
        tag(SILVER_BLOCKS).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_BLOCK).orElseThrow())
        tag(ORES_IN_GROUND_DEEPSLATE).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE).orElseThrow())
        tag(ORES_IN_GROUND_STONE).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE).orElseThrow())
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
        tag(BlockTags.NEEDS_IRON_TOOL).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
    }
}
*///?} else if >=1.19.3 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS_SILVER
import java.util.concurrent.CompletableFuture

open class Block(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        tag(ORES).addTag(SILVER_ORES)
        tag(ORES_SILVER).addTag(SILVER_ORES)
        tag(SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE).orElseThrow()).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE).orElseThrow())
        tag(SILVER_BLOCKS).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_BLOCK).orElseThrow())
        tag(STORAGE_BLOCKS).addTag(SILVER_BLOCKS)
        tag(STORAGE_BLOCKS_SILVER).addTag(SILVER_BLOCKS)
        tag(ORES_IN_GROUND_DEEPSLATE).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE).orElseThrow())
        tag(ORES_IN_GROUND_STONE).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE).orElseThrow())
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
        tag(BlockTags.NEEDS_IRON_TOOL).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
    }
}
*///?} else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.tags.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.STORAGE_BLOCKS_SILVER

open class Block(output: FabricDataGenerator) : FabricTagProvider.BlockTagProvider(output) {
    override fun generateTags() {
        getOrCreateTagBuilder(ORES).addTag(SILVER_ORES)
        getOrCreateTagBuilder(ORES_SILVER).addTag(SILVER_ORES)
        getOrCreateTagBuilder(SILVER_ORES).add(ModBlocks.DEEPSLATE_SILVER_ORE).add(ModBlocks.SILVER_ORE)
        getOrCreateTagBuilder(SILVER_BLOCKS).add(ModBlocks.SILVER_BLOCK)
        getOrCreateTagBuilder(STORAGE_BLOCKS).addTag(SILVER_BLOCKS)
        getOrCreateTagBuilder(STORAGE_BLOCKS_SILVER).addTag(SILVER_BLOCKS)
        getOrCreateTagBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModBlocks.DEEPSLATE_SILVER_ORE)
        getOrCreateTagBuilder(ORES_IN_GROUND_STONE).add(ModBlocks.SILVER_ORE)
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).addTag(SILVER_ORES).addTag(SILVER_BLOCKS)
    }
}
*///?}
