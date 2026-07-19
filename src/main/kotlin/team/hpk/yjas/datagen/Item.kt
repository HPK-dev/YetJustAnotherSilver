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
        valueLookupBuilder(ORES)
            .addTag(SILVER_ORES)

        valueLookupBuilder(SILVER_ORES)
            .add(ModItems.DEEPSLATE_SILVER_ORE)
            .add(ModItems.SILVER_ORE)

        valueLookupBuilder(LEGACY_SILVER_ORES)
            .addTag(SILVER_ORES)

        valueLookupBuilder(ORES_IN_GROUND_DEEPSLATE)
            .add(ModItems.DEEPSLATE_SILVER_ORE)

        valueLookupBuilder(ORES_IN_GROUND_STONE)
            .add(ModItems.SILVER_ORE)

        valueLookupBuilder(RAW_MATERIALS)
            .addTag(SILVER_RAW_MATERIALS)

        valueLookupBuilder(SILVER_RAW_MATERIALS)
            .add(ModItems.RAW_SILVER)

        valueLookupBuilder(LEGACY_RAW_SILVER_ORES)
            .addTag(SILVER_RAW_MATERIALS)

        valueLookupBuilder(INGOTS)
            .addTag(SILVER_INGOTS)

        valueLookupBuilder(SILVER_INGOTS)
            .add(ModItems.SILVER_INGOT)

        valueLookupBuilder(LEGACY_SILVER_INGOTS)
            .addTag(SILVER_INGOTS)

        valueLookupBuilder(NUGGETS)
            .addTag(SILVER_NUGGETS)

        valueLookupBuilder(SILVER_NUGGETS)
            .add(ModItems.SILVER_NUGGET)

        valueLookupBuilder(LEGACY_SILVER_NUGGETS)
            .addTag(SILVER_NUGGETS)

        valueLookupBuilder(STORAGE_BLOCKS)
            .addTag(SILVER_STORAGE_BLOCKS)

        valueLookupBuilder(SILVER_STORAGE_BLOCKS)
            .add(ModItems.SILVER_BLOCK)

        valueLookupBuilder(LEGACY_SILVER_BLOCKS)
            .addTag(SILVER_STORAGE_BLOCKS)
    }
}
