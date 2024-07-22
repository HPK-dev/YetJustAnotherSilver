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