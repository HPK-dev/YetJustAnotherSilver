package team.hpk.yjas.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import team.hpk.yjas.ModMain.MOD_ID
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.Utils.getTranslatableKey
import team.hpk.yjas.block.ModBlocks


object ModItems {

    // item group
    val ITEM_GROUP: RegistryKey<ItemGroup> = RegistryKey.of(
        RegistryKeys.ITEM_GROUP,
        Identifier(MOD_ID, "item_group")
    )


    val SILVER_INGOT = SilverIngot(FabricItemSettings())
    val SILVER_NUGGET = SilverNugget(FabricItemSettings())
    val RAW_SILVER = RawSilver(FabricItemSettings())

    // Block items
    val SILVER_ORE = BlockItem(ModBlocks.SILVER_ORE, FabricItemSettings())
    val DEEPSLATE_SILVER_ORE = BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE, FabricItemSettings())
    val SILVER_BLOCK = BlockItem(ModBlocks.SILVER_BLOCK, FabricItemSettings())


    fun register() {
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
            SILVER_BLOCK
        )

        Registry.register(
            Registries.ITEM,
            getIdentifier("silver_ore"),
            SILVER_ORE
        )

        Registry.register(
            Registries.ITEM,
            getIdentifier("deepslate_silver_ore"),
            DEEPSLATE_SILVER_ORE
        )

    }
}


class SilverIngot(settings: Settings?) : Item(settings)
class SilverNugget(settings: Settings?) : Item(settings)
class RawSilver(settings: Settings?) : Item(settings)