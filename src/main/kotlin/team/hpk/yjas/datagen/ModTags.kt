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

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object ModTags {

    object Items {
        private fun key(id: String): TagKey<Item> =
            TagKey.of(RegistryKeys.ITEM, Identifier(id))

        val ORES = key("c:ores")
        val SILVER_ORES = key("c:silver_ores")
        val SILVER_BLOCKS = key("c:silver_blocks")
        val RAW_ORES = key("c:raw_ores")
        val RAW_SILVER = key("c:raw_silver")
        val RAW_SILVER_ORES= key("c:raw_silver_ores")
        val INGOTS = key("c:ingots")
        val NUGGETS = key("c:nuggets")
        val SILVER_INGOTS = key("c:silver_ingots")
        val SILVER_NUGGETS = key("c:silver_nuggets")
        val ORES_IN_GROUND_STONE = key("c:ore_in_ground/stone")
        val ORES_IN_GROUND_DEEPSLATE = key("c:ore_in_ground/deepslate")

    }

    object Blocks {
        private fun key(id: String): TagKey<Block> =
            TagKey.of(RegistryKeys.BLOCK, Identifier(id))

        val ORES = key("c:ores")
        val BLOCKS = key("c:blocks")
        val SILVER_ORES = key("c:silver_ores")
        val SILVER_BLOCKS = key("c:silver_blocks")
        val ORES_IN_GROUND_STONE = key("c:ore_in_ground/stone")
        val ORES_IN_GROUND_DEEPSLATE = key("c:ore_in_ground/deepslate")
    }
}