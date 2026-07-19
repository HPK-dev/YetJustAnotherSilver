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

import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object ModTags {

    object Items {
        private fun key(path: String): TagKey<Item> =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path))

        val ORES = key("ores")
        val SILVER_ORES = key("ores/silver")
        val LEGACY_SILVER_ORES = key("silver_ores")
        val RAW_MATERIALS = key("raw_materials")
        val SILVER_RAW_MATERIALS = key("raw_materials/silver")
        val LEGACY_RAW_SILVER_ORES = key("raw_silver_ores")
        val INGOTS = key("ingots")
        val SILVER_INGOTS = key("ingots/silver")
        val LEGACY_SILVER_INGOTS = key("silver_ingots")
        val NUGGETS = key("nuggets")
        val SILVER_NUGGETS = key("nuggets/silver")
        val LEGACY_SILVER_NUGGETS = key("silver_nuggets")
        val STORAGE_BLOCKS = key("storage_blocks")
        val SILVER_STORAGE_BLOCKS = key("storage_blocks/silver")
        val LEGACY_SILVER_BLOCKS = key("silver_blocks")
        val ORES_IN_GROUND_STONE = key("ores_in_ground/stone")
        val ORES_IN_GROUND_DEEPSLATE = key("ores_in_ground/deepslate")
    }

    object Blocks {
        private fun key(path: String): TagKey<Block> =
            TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", path))

        val ORES = key("ores")
        val SILVER_ORES = key("ores/silver")
        val LEGACY_SILVER_ORES = key("silver_ores")
        val STORAGE_BLOCKS = key("storage_blocks")
        val SILVER_STORAGE_BLOCKS = key("storage_blocks/silver")
        val LEGACY_SILVER_BLOCKS = key("silver_blocks")
        val ORES_IN_GROUND_STONE = key("ores_in_ground/stone")
        val ORES_IN_GROUND_DEEPSLATE = key("ores_in_ground/deepslate")
    }
}
