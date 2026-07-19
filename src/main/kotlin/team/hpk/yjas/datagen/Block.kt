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

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
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
        valueLookupBuilder(ORES)
            .addTag(SILVER_ORES)

        valueLookupBuilder(SILVER_ORES)
            .add(ModBlocks.DEEPSLATE_SILVER_ORE)
            .add(ModBlocks.SILVER_ORE)

        valueLookupBuilder(LEGACY_SILVER_ORES)
            .addTag(SILVER_ORES)

        valueLookupBuilder(STORAGE_BLOCKS)
            .addTag(SILVER_STORAGE_BLOCKS)

        valueLookupBuilder(SILVER_STORAGE_BLOCKS)
            .add(ModBlocks.SILVER_BLOCK)

        valueLookupBuilder(LEGACY_SILVER_BLOCKS)
            .addTag(SILVER_STORAGE_BLOCKS)

        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE)
            .add(ModBlocks.DEEPSLATE_SILVER_ORE)

        valueLookupBuilder(ORES_IN_GROUND_STONE)
            .add(ModBlocks.SILVER_ORE)

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .addTag(SILVER_ORES)
            .addTag(SILVER_STORAGE_BLOCKS)

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
            .addTag(SILVER_ORES)
            .addTag(SILVER_STORAGE_BLOCKS)
    }
}
