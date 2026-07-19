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
import net.minecraft.registry.RegistryWrapper.WrapperLookup
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

class Item(output: FabricDataOutput, completableFuture: CompletableFuture<WrapperLookup>) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {


    override fun configure(arg: WrapperLookup) {
        getOrCreateTagBuilder(ORES)
            .addTag(ORES_SILVER)

        getOrCreateTagBuilder(ORES_SILVER)
            .add(ModItems.DEEPSLATE_SILVER_ORE)
            .add(ModItems.SILVER_ORE)

        getOrCreateTagBuilder(SILVER_ORES)
            .addTag(ORES_SILVER)

        getOrCreateTagBuilder(SILVER_BLOCKS)
            .addTag(STORAGE_BLOCKS_SILVER)

        getOrCreateTagBuilder(RAW_MATERIALS)
            .addTag(RAW_MATERIALS_SILVER)

        getOrCreateTagBuilder(RAW_MATERIALS_SILVER)
            .add(ModItems.RAW_SILVER)

        getOrCreateTagBuilder(RAW_SILVER)
            .addTag(RAW_MATERIALS_SILVER)

        getOrCreateTagBuilder(RAW_SILVER_ORES)
            .addTag(RAW_MATERIALS_SILVER)

        getOrCreateTagBuilder(ORES_IN_GROUND_DEEPSLATE)
            .add(ModItems.DEEPSLATE_SILVER_ORE)

        getOrCreateTagBuilder(ORES_IN_GROUND_STONE)
            .add(ModItems.SILVER_ORE)

        getOrCreateTagBuilder(INGOTS)
            .addTag(INGOTS_SILVER)

        getOrCreateTagBuilder(INGOTS_SILVER)
            .add(ModItems.SILVER_INGOT)

        getOrCreateTagBuilder(NUGGETS)
            .addTag(NUGGETS_SILVER)

        getOrCreateTagBuilder(NUGGETS_SILVER)
            .add(ModItems.SILVER_NUGGET)

        getOrCreateTagBuilder(SILVER_INGOTS)
            .addTag(INGOTS_SILVER)

        getOrCreateTagBuilder(SILVER_NUGGETS)
            .addTag(NUGGETS_SILVER)

        getOrCreateTagBuilder(STORAGE_BLOCKS)
            .addTag(STORAGE_BLOCKS_SILVER)

        getOrCreateTagBuilder(STORAGE_BLOCKS_SILVER)
            .add(ModItems.SILVER_BLOCK)
    }
}
