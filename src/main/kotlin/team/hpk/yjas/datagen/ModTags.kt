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
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.tags.BlockItemTagId
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object ModTags {
    private fun blockItemKey(path: String): BlockItemTagId {
        val identifier = Identifier.fromNamespaceAndPath("c", path)
        return BlockItemTagId.create(identifier, identifier)
    }

    object BlockItems {
        val ORES = blockItemKey("ores")
        val SILVER_ORES = blockItemKey("ores/silver")
        val LEGACY_SILVER_ORES = blockItemKey("silver_ores")
        val STORAGE_BLOCKS = blockItemKey("storage_blocks")
        val SILVER_STORAGE_BLOCKS = blockItemKey("storage_blocks/silver")
        val LEGACY_SILVER_BLOCKS = blockItemKey("silver_blocks")
        val ORES_IN_GROUND_STONE = blockItemKey("ores_in_ground/stone")
        val ORES_IN_GROUND_DEEPSLATE = blockItemKey("ores_in_ground/deepslate")
    }

    object Items {
        private fun key(path: String): TagKey<Item> =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path))

        val ORES = BlockItems.ORES.item()
        val SILVER_ORES = BlockItems.SILVER_ORES.item()
        val LEGACY_SILVER_ORES = BlockItems.LEGACY_SILVER_ORES.item()
        val RAW_MATERIALS = key("raw_materials")
        val SILVER_RAW_MATERIALS = key("raw_materials/silver")
        val LEGACY_RAW_SILVER_ORES = key("raw_silver_ores")
        val INGOTS = key("ingots")
        val SILVER_INGOTS = key("ingots/silver")
        val LEGACY_SILVER_INGOTS = key("silver_ingots")
        val NUGGETS = key("nuggets")
        val SILVER_NUGGETS = key("nuggets/silver")
        val LEGACY_SILVER_NUGGETS = key("silver_nuggets")
        val STORAGE_BLOCKS = BlockItems.STORAGE_BLOCKS.item()
        val SILVER_STORAGE_BLOCKS = BlockItems.SILVER_STORAGE_BLOCKS.item()
        val LEGACY_SILVER_BLOCKS = BlockItems.LEGACY_SILVER_BLOCKS.item()
        val ORES_IN_GROUND_STONE = BlockItems.ORES_IN_GROUND_STONE.item()
        val ORES_IN_GROUND_DEEPSLATE = BlockItems.ORES_IN_GROUND_DEEPSLATE.item()
    }

    object Blocks {
        val ORES: TagKey<Block> = BlockItems.ORES.block()
        val SILVER_ORES: TagKey<Block> = BlockItems.SILVER_ORES.block()
        val LEGACY_SILVER_ORES: TagKey<Block> = BlockItems.LEGACY_SILVER_ORES.block()
        val STORAGE_BLOCKS: TagKey<Block> = BlockItems.STORAGE_BLOCKS.block()
        val SILVER_STORAGE_BLOCKS: TagKey<Block> = BlockItems.SILVER_STORAGE_BLOCKS.block()
        val LEGACY_SILVER_BLOCKS: TagKey<Block> = BlockItems.LEGACY_SILVER_BLOCKS.block()
        val ORES_IN_GROUND_STONE: TagKey<Block> = BlockItems.ORES_IN_GROUND_STONE.block()
        val ORES_IN_GROUND_DEEPSLATE: TagKey<Block> = BlockItems.ORES_IN_GROUND_DEEPSLATE.block()
    }
}
//?} else if >=1.21.11 {
/*import net.minecraft.core.registries.Registries
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
*///?} else {
/*import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
//? if >=1.19.3 {
import net.minecraft.core.registries.Registries
//?} else {
/*import net.minecraft.core.Registry
*///?}

object ModTags {
    private fun itemId(id: String): ResourceLocation {
        val namespace = id.substringBefore(':')
        val path = id.substringAfter(':')
        //? if >=1.21 {
        return ResourceLocation.fromNamespaceAndPath(namespace, path)
        //?} else {
        /*return ResourceLocation(namespace, path)
        *///?}
    }

    private fun blockId(id: String): ResourceLocation = itemId(id)

    object Items {
        private fun key(id: String): TagKey<Item> = TagKey.create(
            //? if >=1.19.3
            Registries.ITEM,
            //? if <1.19.3
            /*Registry.ITEM_REGISTRY,*/
            itemId(id)
        )
        val ORES = key("c:ores")
        val ORES_SILVER = key("c:ores/silver")
        val SILVER_ORES = key("c:silver_ores")
        val SILVER_BLOCKS = key("c:silver_blocks")
        val RAW_ORES = key("c:raw_ores")
        val RAW_MATERIALS = key("c:raw_materials")
        val RAW_MATERIALS_SILVER = key("c:raw_materials/silver")
        val RAW_SILVER = key("c:raw_silver")
        val RAW_SILVER_ORES = key("c:raw_silver_ores")
        val INGOTS = key("c:ingots")
        val INGOTS_SILVER = key("c:ingots/silver")
        val NUGGETS = key("c:nuggets")
        val NUGGETS_SILVER = key("c:nuggets/silver")
        val STORAGE_BLOCKS = key("c:storage_blocks")
        val STORAGE_BLOCKS_SILVER = key("c:storage_blocks/silver")
        val SILVER_INGOTS = key("c:silver_ingots")
        val SILVER_NUGGETS = key("c:silver_nuggets")
        val ORES_IN_GROUND_STONE = key("c:ores_in_ground/stone")
        val ORES_IN_GROUND_DEEPSLATE = key("c:ores_in_ground/deepslate")
    }

    object Blocks {
        private fun key(id: String): TagKey<Block> = TagKey.create(
            //? if >=1.19.3
            Registries.BLOCK,
            //? if <1.19.3
            /*Registry.BLOCK_REGISTRY,*/
            blockId(id)
        )
        val ORES = key("c:ores")
        val BLOCKS = key("c:blocks")
        val ORES_SILVER = key("c:ores/silver")
        val SILVER_ORES = key("c:silver_ores")
        val STORAGE_BLOCKS = key("c:storage_blocks")
        val STORAGE_BLOCKS_SILVER = key("c:storage_blocks/silver")
        val SILVER_BLOCKS = key("c:silver_blocks")
        val ORES_IN_GROUND_STONE = key("c:ores_in_ground/stone")
        val ORES_IN_GROUND_DEEPSLATE = key("c:ores_in_ground/deepslate")
    }
}
*///?}
