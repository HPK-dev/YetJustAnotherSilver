package team.hpk.yjas.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import team.hpk.yjas.Registry.Companion.ITEM_GROUP
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.Utils.getTranslatableKey
import team.hpk.yjas.block.BlockRegistry.Companion.DEEPSLATE_SILVER_ORE
import team.hpk.yjas.block.BlockRegistry.Companion.SILVER_BLOCK
import team.hpk.yjas.block.BlockRegistry.Companion.SILVER_ORE


class ItemRegistry {

    companion object {


        val SILVER_INGOT = SilverIngot(FabricItemSettings())
        val SILVER_NUGGET = SilverNugget(FabricItemSettings())
        val RAW_SILVER = RawSilver(FabricItemSettings())
    }

    init {
        Registry.register(
            Registries.ITEM_GROUP,
            ITEM_GROUP,
            FabricItemGroup.builder()
                .displayName(getTranslatableKey("item_group"))
                .icon { ItemStack(SILVER_INGOT) }
                .entries { _, entries ->
                    entries.add(SILVER_INGOT)
                    entries.add(SILVER_NUGGET)
                    entries.add(SILVER_BLOCK)
                    entries.add(RAW_SILVER)
                    entries.add(SILVER_ORE)
                    entries.add(DEEPSLATE_SILVER_ORE)
                }
                .build()
        )


        Registry.register(
            Registries.ITEM,
            getIdentifier("silver_ingot"),
            SILVER_INGOT
        )

        Registry.register(
            Registries.ITEM,
            getIdentifier("silver_nugget"),
            SILVER_NUGGET
        )

        Registry.register(
            Registries.ITEM,
            getIdentifier("raw_silver"),
            RAW_SILVER
        )

        // For block items

        Registry.register(
            Registries.ITEM,
            getIdentifier("silver_block"),
            BlockItem(SILVER_BLOCK, FabricItemSettings())
        )

        Registry.register(
            Registries.ITEM,
            getIdentifier("silver_ore"),
            BlockItem(SILVER_ORE, FabricItemSettings())
        )

        Registry.register(
            Registries.ITEM,
            getIdentifier("deepslate_silver_ore"),
            BlockItem(DEEPSLATE_SILVER_ORE, FabricItemSettings())
        )

    }
}


class SilverIngot(settings: Settings?) : Item(settings)
class SilverNugget(settings: Settings?) : Item(settings)
class RawSilver(settings: Settings?) : Item(settings)