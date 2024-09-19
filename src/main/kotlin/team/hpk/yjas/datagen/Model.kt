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

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class Model(output: FabricDataGenerator) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.apply {
            registerSimpleCubeAll(ModBlocks.SILVER_BLOCK)
            registerSimpleCubeAll(ModBlocks.SILVER_ORE)
            registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE)
        }
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.apply {
            register(ModItems.RAW_SILVER, Models.GENERATED)
            register(ModItems.SILVER_INGOT, Models.GENERATED)
            register(ModItems.SILVER_NUGGET, Models.GENERATED)

        }
    }

}