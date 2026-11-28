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

//? if >=26.1 {
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.model.ModelTemplates
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class Model(output: FabricPackOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_BLOCK)
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_ORE)
        blockStateModelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {
        itemModelGenerator.generateFlatItem(ModItems.RAW_SILVER, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM)
    }
}
//?} else if >=1.21.11 {
/*import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.model.ModelTemplates
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class Model(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_BLOCK)
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_ORE)
        blockStateModelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {
        itemModelGenerator.generateFlatItem(ModItems.RAW_SILVER, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM)
    }
}
*///?} else if >=1.21.4 {
/*import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.model.ModelTemplates
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class Model(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_BLOCK)
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_ORE)
        blockStateModelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {
        itemModelGenerator.generateFlatItem(ModItems.RAW_SILVER, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM)
    }
}
*///?} else if >=1.19.3 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelTemplates
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class Model(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_BLOCK)
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_ORE)
        blockStateModelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {
        itemModelGenerator.generateFlatItem(ModItems.RAW_SILVER, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM)
    }
}
*///?} else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelTemplates
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class Model(output: FabricDataGenerator) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_BLOCK)
        blockStateModelGenerator.createTrivialCube(ModBlocks.SILVER_ORE)
        blockStateModelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {
        itemModelGenerator.generateFlatItem(ModItems.RAW_SILVER, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM)
        itemModelGenerator.generateFlatItem(ModItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM)
    }
}
*///?}
