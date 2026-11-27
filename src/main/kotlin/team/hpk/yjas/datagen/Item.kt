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
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricPackOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.ItemTagsProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        builder(ORES).addTag(SILVER_ORES)
        builder(SILVER_ORES).add(ModBlocks.DEEPSLATE_SILVER_ORE_ID, ModBlocks.SILVER_ORE_ID)
        builder(LEGACY_SILVER_ORES).addTag(SILVER_ORES)
        builder(ORES_IN_GROUND_DEEPSLATE).add(ModBlocks.DEEPSLATE_SILVER_ORE_ID)
        builder(ORES_IN_GROUND_STONE).add(ModBlocks.SILVER_ORE_ID)
        builder(RAW_MATERIALS).addTag(SILVER_RAW_MATERIALS)
        builder(SILVER_RAW_MATERIALS).add(ModItems.RAW_SILVER_KEY)
        builder(LEGACY_RAW_SILVER_ORES).addTag(SILVER_RAW_MATERIALS)
        builder(INGOTS).addTag(SILVER_INGOTS)
        builder(SILVER_INGOTS).add(ModItems.SILVER_INGOT_KEY)
        builder(LEGACY_SILVER_INGOTS).addTag(SILVER_INGOTS)
        builder(NUGGETS).addTag(SILVER_NUGGETS)
        builder(SILVER_NUGGETS).add(ModItems.SILVER_NUGGET_KEY)
        builder(LEGACY_SILVER_NUGGETS).addTag(SILVER_NUGGETS)
        builder(STORAGE_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        builder(SILVER_STORAGE_BLOCKS).add(ModBlocks.SILVER_BLOCK_ID)
        builder(LEGACY_SILVER_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
    }
}
//?} else if >=26.1 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricPackOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.ItemTagsProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        valueLookupBuilder(ORES).addTag(SILVER_ORES)
        valueLookupBuilder(SILVER_ORES).add(ModItems.DEEPSLATE_SILVER_ORE).add(ModItems.SILVER_ORE)
        valueLookupBuilder(LEGACY_SILVER_ORES).addTag(SILVER_ORES)
        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModItems.DEEPSLATE_SILVER_ORE)
        valueLookupBuilder(ORES_IN_GROUND_STONE).add(ModItems.SILVER_ORE)
        valueLookupBuilder(RAW_MATERIALS).addTag(SILVER_RAW_MATERIALS)
        valueLookupBuilder(SILVER_RAW_MATERIALS).add(ModItems.RAW_SILVER)
        valueLookupBuilder(LEGACY_RAW_SILVER_ORES).addTag(SILVER_RAW_MATERIALS)
        valueLookupBuilder(INGOTS).addTag(SILVER_INGOTS)
        valueLookupBuilder(SILVER_INGOTS).add(ModItems.SILVER_INGOT)
        valueLookupBuilder(LEGACY_SILVER_INGOTS).addTag(SILVER_INGOTS)
        valueLookupBuilder(NUGGETS).addTag(SILVER_NUGGETS)
        valueLookupBuilder(SILVER_NUGGETS).add(ModItems.SILVER_NUGGET)
        valueLookupBuilder(LEGACY_SILVER_NUGGETS).addTag(SILVER_NUGGETS)
        valueLookupBuilder(STORAGE_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(SILVER_STORAGE_BLOCKS).add(ModItems.SILVER_BLOCK)
        valueLookupBuilder(LEGACY_SILVER_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
    }
}
*///?} else if >=1.21.11 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.LEGACY_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        valueLookupBuilder(ORES).addTag(SILVER_ORES)
        valueLookupBuilder(SILVER_ORES).add(ModItems.DEEPSLATE_SILVER_ORE).add(ModItems.SILVER_ORE)
        valueLookupBuilder(LEGACY_SILVER_ORES).addTag(SILVER_ORES)
        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModItems.DEEPSLATE_SILVER_ORE)
        valueLookupBuilder(ORES_IN_GROUND_STONE).add(ModItems.SILVER_ORE)
        valueLookupBuilder(RAW_MATERIALS).addTag(SILVER_RAW_MATERIALS)
        valueLookupBuilder(SILVER_RAW_MATERIALS).add(ModItems.RAW_SILVER)
        valueLookupBuilder(LEGACY_RAW_SILVER_ORES).addTag(SILVER_RAW_MATERIALS)
        valueLookupBuilder(INGOTS).addTag(SILVER_INGOTS)
        valueLookupBuilder(SILVER_INGOTS).add(ModItems.SILVER_INGOT)
        valueLookupBuilder(LEGACY_SILVER_INGOTS).addTag(SILVER_INGOTS)
        valueLookupBuilder(NUGGETS).addTag(SILVER_NUGGETS)
        valueLookupBuilder(SILVER_NUGGETS).add(ModItems.SILVER_NUGGET)
        valueLookupBuilder(LEGACY_SILVER_NUGGETS).addTag(SILVER_NUGGETS)
        valueLookupBuilder(STORAGE_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
        valueLookupBuilder(SILVER_STORAGE_BLOCKS).add(ModItems.SILVER_BLOCK)
        valueLookupBuilder(LEGACY_SILVER_BLOCKS).addTag(SILVER_STORAGE_BLOCKS)
    }
}
*///?} else if >=1.21.6 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.INGOTS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS_SILVER
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        valueLookupBuilder(ORES).addTag(SILVER_ORES)
        valueLookupBuilder(ORES_SILVER).addTag(SILVER_ORES)
        valueLookupBuilder(SILVER_ORES).add(ModItems.DEEPSLATE_SILVER_ORE).add(ModItems.SILVER_ORE)
        valueLookupBuilder(SILVER_BLOCKS).add(ModItems.SILVER_BLOCK)
        valueLookupBuilder(RAW_MATERIALS).addTag(RAW_SILVER_ORES)
        valueLookupBuilder(RAW_MATERIALS_SILVER).addTag(RAW_SILVER_ORES)
        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModItems.DEEPSLATE_SILVER_ORE)
        valueLookupBuilder(ORES_IN_GROUND_STONE).add(ModItems.SILVER_ORE)
        valueLookupBuilder(INGOTS).addTag(SILVER_INGOTS)
        valueLookupBuilder(INGOTS_SILVER).addTag(SILVER_INGOTS)
        valueLookupBuilder(NUGGETS).addTag(SILVER_NUGGETS)
        valueLookupBuilder(NUGGETS_SILVER).addTag(SILVER_NUGGETS)
        valueLookupBuilder(SILVER_INGOTS).add(ModItems.SILVER_INGOT)
        valueLookupBuilder(SILVER_NUGGETS).add(ModItems.SILVER_NUGGET)
        valueLookupBuilder(STORAGE_BLOCKS).addTag(SILVER_BLOCKS)
        valueLookupBuilder(STORAGE_BLOCKS_SILVER).addTag(SILVER_BLOCKS)
        valueLookupBuilder(RAW_SILVER_ORES).add(ModItems.RAW_SILVER)
    }
}
*///?} else if >=1.21.4 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.INGOTS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS_SILVER
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        tag(ORES).addTag(ORES_SILVER)
        tag(ORES_SILVER).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow()).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(SILVER_ORES).addTag(ORES_SILVER)
        tag(SILVER_BLOCKS).addTag(STORAGE_BLOCKS_SILVER)
        tag(RAW_MATERIALS).addTag(RAW_MATERIALS_SILVER)
        tag(RAW_MATERIALS_SILVER).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.RAW_SILVER).orElseThrow())
        tag(RAW_SILVER).addTag(RAW_MATERIALS_SILVER)
        tag(RAW_SILVER_ORES).addTag(RAW_MATERIALS_SILVER)
        tag(ORES_IN_GROUND_DEEPSLATE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow())
        tag(ORES_IN_GROUND_STONE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(INGOTS).addTag(INGOTS_SILVER)
        tag(INGOTS_SILVER).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_INGOT).orElseThrow())
        tag(NUGGETS).addTag(NUGGETS_SILVER)
        tag(NUGGETS_SILVER).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_NUGGET).orElseThrow())
        tag(SILVER_INGOTS).addTag(INGOTS_SILVER)
        tag(SILVER_NUGGETS).addTag(NUGGETS_SILVER)
        tag(STORAGE_BLOCKS).addTag(STORAGE_BLOCKS_SILVER)
        tag(STORAGE_BLOCKS_SILVER).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_BLOCK).orElseThrow())
    }
}
*///?} else if >=1.20 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.INGOTS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS_SILVER
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        tag(ORES).addTag(SILVER_ORES)
        tag(ORES_SILVER).addTag(SILVER_ORES)
        tag(SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow()).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(SILVER_BLOCKS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_BLOCK).orElseThrow())
        tag(RAW_MATERIALS).addTag(RAW_SILVER_ORES)
        tag(RAW_MATERIALS_SILVER).addTag(RAW_SILVER_ORES)
        tag(ORES_IN_GROUND_DEEPSLATE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow())
        tag(ORES_IN_GROUND_STONE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(INGOTS).addTag(SILVER_INGOTS)
        tag(INGOTS_SILVER).addTag(SILVER_INGOTS)
        tag(NUGGETS).addTag(SILVER_NUGGETS)
        tag(NUGGETS_SILVER).addTag(SILVER_NUGGETS)
        tag(SILVER_INGOTS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_INGOT).orElseThrow())
        tag(SILVER_NUGGETS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_NUGGET).orElseThrow())
        tag(STORAGE_BLOCKS).addTag(SILVER_BLOCKS)
        tag(STORAGE_BLOCKS_SILVER).addTag(SILVER_BLOCKS)
        tag(RAW_SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.RAW_SILVER).orElseThrow())
    }
}
*///?} else if 1.19.4 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.INGOTS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_ORES
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS_SILVER
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(
    output: FabricDataOutput,
    completableFuture: CompletableFuture<HolderLookup.Provider>,
    blockTags: Block
) : FabricTagProvider.ItemTagProvider(output, completableFuture, blockTags) {
    override fun addTags(arg: HolderLookup.Provider) {
        tag(ORES).addTag(SILVER_ORES)
        tag(ORES_SILVER).addTag(SILVER_ORES)
        tag(SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow()).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(SILVER_BLOCKS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_BLOCK).orElseThrow())
        tag(RAW_ORES).addTag(RAW_SILVER_ORES)
        tag(RAW_MATERIALS).addTag(RAW_SILVER_ORES)
        tag(RAW_MATERIALS_SILVER).addTag(RAW_SILVER_ORES)
        tag(ORES_IN_GROUND_DEEPSLATE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow())
        tag(ORES_IN_GROUND_STONE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(INGOTS).addTag(SILVER_INGOTS)
        tag(INGOTS_SILVER).addTag(SILVER_INGOTS)
        tag(NUGGETS).addTag(SILVER_NUGGETS)
        tag(NUGGETS_SILVER).addTag(SILVER_NUGGETS)
        tag(SILVER_INGOTS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_INGOT).orElseThrow())
        tag(SILVER_NUGGETS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_NUGGET).orElseThrow())
        tag(STORAGE_BLOCKS).addTag(SILVER_BLOCKS)
        tag(STORAGE_BLOCKS_SILVER).addTag(SILVER_BLOCKS)
        tag(RAW_SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.RAW_SILVER).orElseThrow())
    }
}
*///?} else if >=1.19.3 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.INGOTS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_ORES
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS_SILVER
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricDataOutput, completableFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        tag(ORES).addTag(SILVER_ORES)
        tag(ORES_SILVER).addTag(SILVER_ORES)
        tag(SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow()).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(SILVER_BLOCKS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_BLOCK).orElseThrow())
        tag(RAW_ORES).addTag(RAW_SILVER_ORES)
        tag(RAW_MATERIALS).addTag(RAW_SILVER_ORES)
        tag(RAW_MATERIALS_SILVER).addTag(RAW_SILVER_ORES)
        tag(ORES_IN_GROUND_DEEPSLATE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.DEEPSLATE_SILVER_ORE).orElseThrow())
        tag(ORES_IN_GROUND_STONE).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_ORE).orElseThrow())
        tag(INGOTS).addTag(SILVER_INGOTS)
        tag(INGOTS_SILVER).addTag(SILVER_INGOTS)
        tag(NUGGETS).addTag(SILVER_NUGGETS)
        tag(NUGGETS_SILVER).addTag(SILVER_NUGGETS)
        tag(SILVER_INGOTS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_INGOT).orElseThrow())
        tag(SILVER_NUGGETS).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.SILVER_NUGGET).orElseThrow())
        tag(STORAGE_BLOCKS).addTag(SILVER_BLOCKS)
        tag(STORAGE_BLOCKS_SILVER).addTag(SILVER_BLOCKS)
        tag(RAW_SILVER_ORES).add(net.minecraft.core.registries.BuiltInRegistries.ITEM.getResourceKey(ModItems.RAW_SILVER).orElseThrow())
    }
}
*///?} else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.INGOTS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.ORES_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS
import team.hpk.yjas.datagen.ModTags.Items.RAW_MATERIALS_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_ORES
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.STORAGE_BLOCKS_SILVER
import team.hpk.yjas.item.ModItems

class Item(output: FabricDataGenerator) : FabricTagProvider.ItemTagProvider(output) {
    override fun generateTags() {
        getOrCreateTagBuilder(ORES).addTag(SILVER_ORES)
        getOrCreateTagBuilder(ORES_SILVER).addTag(SILVER_ORES)
        getOrCreateTagBuilder(SILVER_ORES).add(ModItems.DEEPSLATE_SILVER_ORE).add(ModItems.SILVER_ORE)
        getOrCreateTagBuilder(SILVER_BLOCKS).add(ModItems.SILVER_BLOCK)
        getOrCreateTagBuilder(RAW_ORES).addTag(RAW_SILVER_ORES)
        getOrCreateTagBuilder(RAW_MATERIALS).addTag(RAW_SILVER_ORES)
        getOrCreateTagBuilder(RAW_MATERIALS_SILVER).addTag(RAW_SILVER_ORES)
        getOrCreateTagBuilder(ORES_IN_GROUND_DEEPSLATE).add(ModItems.DEEPSLATE_SILVER_ORE)
        getOrCreateTagBuilder(ORES_IN_GROUND_STONE).add(ModItems.SILVER_ORE)
        getOrCreateTagBuilder(INGOTS).addTag(SILVER_INGOTS)
        getOrCreateTagBuilder(INGOTS_SILVER).addTag(SILVER_INGOTS)
        getOrCreateTagBuilder(NUGGETS).addTag(SILVER_NUGGETS)
        getOrCreateTagBuilder(NUGGETS_SILVER).addTag(SILVER_NUGGETS)
        getOrCreateTagBuilder(SILVER_INGOTS).add(ModItems.SILVER_INGOT)
        getOrCreateTagBuilder(SILVER_NUGGETS).add(ModItems.SILVER_NUGGET)
        getOrCreateTagBuilder(STORAGE_BLOCKS).addTag(SILVER_BLOCKS)
        getOrCreateTagBuilder(STORAGE_BLOCKS_SILVER).addTag(SILVER_BLOCKS)
        getOrCreateTagBuilder(RAW_SILVER_ORES).add(ModItems.RAW_SILVER)
    }
}
*///?}
