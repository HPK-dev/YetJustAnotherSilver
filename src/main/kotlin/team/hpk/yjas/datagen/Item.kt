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
        builder(ORES)
            .addTag(SILVER_ORES)

        builder(SILVER_ORES)
            .add(ModBlocks.DEEPSLATE_SILVER_ORE_ID, ModBlocks.SILVER_ORE_ID)

        builder(LEGACY_SILVER_ORES)
            .addTag(SILVER_ORES)

        builder(ORES_IN_GROUND_DEEPSLATE)
            .add(ModBlocks.DEEPSLATE_SILVER_ORE_ID)

        builder(ORES_IN_GROUND_STONE)
            .add(ModBlocks.SILVER_ORE_ID)

        builder(RAW_MATERIALS)
            .addTag(SILVER_RAW_MATERIALS)

        builder(SILVER_RAW_MATERIALS)
            .add(ModItems.RAW_SILVER_KEY)

        builder(LEGACY_RAW_SILVER_ORES)
            .addTag(SILVER_RAW_MATERIALS)

        builder(INGOTS)
            .addTag(SILVER_INGOTS)

        builder(SILVER_INGOTS)
            .add(ModItems.SILVER_INGOT_KEY)

        builder(LEGACY_SILVER_INGOTS)
            .addTag(SILVER_INGOTS)

        builder(NUGGETS)
            .addTag(SILVER_NUGGETS)

        builder(SILVER_NUGGETS)
            .add(ModItems.SILVER_NUGGET_KEY)

        builder(LEGACY_SILVER_NUGGETS)
            .addTag(SILVER_NUGGETS)

        builder(STORAGE_BLOCKS)
            .addTag(SILVER_STORAGE_BLOCKS)

        builder(SILVER_STORAGE_BLOCKS)
            .add(ModBlocks.SILVER_BLOCK_ID)

        builder(LEGACY_SILVER_BLOCKS)
            .addTag(SILVER_STORAGE_BLOCKS)
    }
}
