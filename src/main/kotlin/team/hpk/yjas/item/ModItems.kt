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

package team.hpk.yjas.item

//? if >=26.2 {
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.references.BlockItemId
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.Utils.getTranslatableKey
import team.hpk.yjas.block.ModBlocks

object ModItems {
    private val ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB,
        getIdentifier("item_group")
    )

    val SILVER_INGOT_KEY: ResourceKey<Item> = itemKey("silver_ingot")
    val SILVER_NUGGET_KEY: ResourceKey<Item> = itemKey("silver_nugget")
    val RAW_SILVER_KEY: ResourceKey<Item> = itemKey("raw_silver")

    val SILVER_INGOT = register(SILVER_INGOT_KEY) { Item(it) }
    val SILVER_NUGGET = register(SILVER_NUGGET_KEY) { Item(it) }
    val RAW_SILVER = register(RAW_SILVER_KEY) { Item(it) }

    val SILVER_ORE = registerBlockItem(ModBlocks.SILVER_ORE_ID, ModBlocks.SILVER_ORE)
    val DEEPSLATE_SILVER_ORE = registerBlockItem(ModBlocks.DEEPSLATE_SILVER_ORE_ID, ModBlocks.DEEPSLATE_SILVER_ORE)
    val SILVER_BLOCK = registerBlockItem(ModBlocks.SILVER_BLOCK_ID, ModBlocks.SILVER_BLOCK)

    private fun itemKey(name: String): ResourceKey<Item> =
        ResourceKey.create(Registries.ITEM, getIdentifier(name))

    private fun <T : Item> register(key: ResourceKey<Item>, factory: (Item.Properties) -> T): T {
        return Registry.register(BuiltInRegistries.ITEM, key, factory(Item.Properties().setId(key)))
    }

    private fun registerBlockItem(id: BlockItemId, block: Block): BlockItem =
        register(id.item()) { BlockItem(block, it.useBlockDescriptionPrefix()) }

    fun initialize() {
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ITEM_GROUP_KEY,
            FabricCreativeModeTab.builder()
                .title(getTranslatableKey("item_group"))
                .icon { ItemStack(SILVER_INGOT) }
                .displayItems { _, entries ->
                    entries.accept(SILVER_INGOT)
                    entries.accept(SILVER_NUGGET)
                    entries.accept(SILVER_BLOCK)
                    entries.accept(RAW_SILVER)
                    entries.accept(SILVER_ORE)
                    entries.accept(DEEPSLATE_SILVER_ORE)
                }
                .build()
        )
    }
}
//?} else if >=26.1 {
/*import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.Utils.getTranslatableKey
import team.hpk.yjas.block.ModBlocks

object ModItems {
    private val ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> =
        ResourceKey.create(Registries.CREATIVE_MODE_TAB, getIdentifier("item_group"))

    val SILVER_INGOT = register("silver_ingot") { Item(it) }
    val SILVER_NUGGET = register("silver_nugget") { Item(it) }
    val RAW_SILVER = register("raw_silver") { Item(it) }
    val SILVER_ORE = registerBlockItem("silver_ore", ModBlocks.SILVER_ORE)
    val DEEPSLATE_SILVER_ORE = registerBlockItem("deepslate_silver_ore", ModBlocks.DEEPSLATE_SILVER_ORE)
    val SILVER_BLOCK = registerBlockItem("silver_block", ModBlocks.SILVER_BLOCK)

    private fun <T : Item> register(name: String, factory: (Item.Properties) -> T): T {
        val key = ResourceKey.create(Registries.ITEM, getIdentifier(name))
        return Registry.register(BuiltInRegistries.ITEM, key, factory(Item.Properties().setId(key)))
    }

    private fun registerBlockItem(name: String, block: Block): BlockItem =
        register(name) { BlockItem(block, it.useBlockDescriptionPrefix()) }

    fun initialize() {
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ITEM_GROUP_KEY,
            FabricCreativeModeTab.builder()
                .title(getTranslatableKey("item_group"))
                .icon { ItemStack(SILVER_INGOT) }
                .displayItems { _, entries ->
                    entries.accept(SILVER_INGOT)
                    entries.accept(SILVER_NUGGET)
                    entries.accept(SILVER_BLOCK)
                    entries.accept(RAW_SILVER)
                    entries.accept(SILVER_ORE)
                    entries.accept(DEEPSLATE_SILVER_ORE)
                }
                .build()
        )
    }
}
*///?} else if >=1.21.11 {
/*import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.Utils.getTranslatableKey
import team.hpk.yjas.block.ModBlocks

object ModItems {
    private val ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> =
        ResourceKey.create(Registries.CREATIVE_MODE_TAB, getIdentifier("item_group"))

    val SILVER_INGOT = register("silver_ingot") { Item(it) }
    val SILVER_NUGGET = register("silver_nugget") { Item(it) }
    val RAW_SILVER = register("raw_silver") { Item(it) }
    val SILVER_ORE = registerBlockItem("silver_ore", ModBlocks.SILVER_ORE)
    val DEEPSLATE_SILVER_ORE = registerBlockItem("deepslate_silver_ore", ModBlocks.DEEPSLATE_SILVER_ORE)
    val SILVER_BLOCK = registerBlockItem("silver_block", ModBlocks.SILVER_BLOCK)

    private fun <T : Item> register(name: String, factory: (Item.Properties) -> T): T {
        val key = ResourceKey.create(Registries.ITEM, getIdentifier(name))
        return Registry.register(BuiltInRegistries.ITEM, key, factory(Item.Properties().setId(key)))
    }

    private fun registerBlockItem(name: String, block: Block): BlockItem =
        register(name) { BlockItem(block, it.useBlockDescriptionPrefix()) }

    fun initialize() {
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ITEM_GROUP_KEY,
            FabricItemGroup.builder()
                .title(getTranslatableKey("item_group"))
                .icon { ItemStack(SILVER_INGOT) }
                .displayItems { _, entries ->
                    entries.accept(SILVER_INGOT)
                    entries.accept(SILVER_NUGGET)
                    entries.accept(SILVER_BLOCK)
                    entries.accept(RAW_SILVER)
                    entries.accept(SILVER_ORE)
                    entries.accept(DEEPSLATE_SILVER_ORE)
                }
                .build()
        )
    }
}
*///?} else if >=1.20 {
/*import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.Utils.getTranslatableKey
import team.hpk.yjas.block.ModBlocks

object ModItems {
    private val ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> =
        ResourceKey.create(Registries.CREATIVE_MODE_TAB, getIdentifier("item_group"))

    val SILVER_INGOT = item("silver_ingot", false)
    val SILVER_NUGGET = item("silver_nugget", false)
    val RAW_SILVER = item("raw_silver", false)
    val SILVER_ORE = item("silver_ore", true, ModBlocks.SILVER_ORE)
    val DEEPSLATE_SILVER_ORE = item("deepslate_silver_ore", true, ModBlocks.DEEPSLATE_SILVER_ORE)
    val SILVER_BLOCK = item("silver_block", true, ModBlocks.SILVER_BLOCK)

    private fun item(name: String, blockItem: Boolean, block: Block? = null): Item {
        val key = ResourceKey.create(Registries.ITEM, getIdentifier(name))
        var properties = Item.Properties()
        //? if >=1.21.2
        /*properties = properties.setId(key)*/
        //? if >=1.21.2 && (>=1.21.2 <1.21.6 || >=1.21.9)
        /*if (blockItem) properties = properties.useBlockDescriptionPrefix()*/
        val created = if (blockItem) BlockItem(block!!, properties) else Item(properties)
        //? if >=1.21.4 <1.21.6
        /*return Registry.register(BuiltInRegistries.ITEM, key, created)*/
        //? if <1.21.4 || >=1.21.6
        return created
    }

    fun register() {
        //? if <1.21.4 || >=1.21.6 {
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_nugget"), SILVER_NUGGET)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("raw_silver"), RAW_SILVER)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
        //?}
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ITEM_GROUP_KEY,
            FabricItemGroup.builder()
                .title(getTranslatableKey("item_group"))
                .icon { ItemStack(SILVER_INGOT) }
                .displayItems { _, entries ->
                    entries.accept(SILVER_INGOT)
                    entries.accept(SILVER_NUGGET)
                    entries.accept(SILVER_BLOCK)
                    entries.accept(RAW_SILVER)
                    entries.accept(SILVER_ORE)
                    entries.accept(DEEPSLATE_SILVER_ORE)
                }
                .build()
        )
    }
}
*///?} else if >=1.19.4 {
/*import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModItems {
    val SILVER_INGOT = Item(FabricItemSettings())
    val SILVER_NUGGET = Item(FabricItemSettings())
    val RAW_SILVER = Item(FabricItemSettings())
    val SILVER_ORE = BlockItem(ModBlocks.SILVER_ORE, FabricItemSettings())
    val DEEPSLATE_SILVER_ORE = BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE, FabricItemSettings())
    val SILVER_BLOCK = BlockItem(ModBlocks.SILVER_BLOCK, FabricItemSettings())

    val ITEM_GROUP = FabricItemGroup.builder(getIdentifier("item_group"))
        .title(net.minecraft.network.chat.Component.translatable("yjas.item_group"))
        .icon { ItemStack(SILVER_INGOT) }
        .displayItems { _, entries ->
            entries.accept(SILVER_INGOT)
            entries.accept(SILVER_NUGGET)
            entries.accept(SILVER_BLOCK)
            entries.accept(RAW_SILVER)
            entries.accept(SILVER_ORE)
            entries.accept(DEEPSLATE_SILVER_ORE)
        }
        .build()

    fun register() {
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_nugget"), SILVER_NUGGET)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("raw_silver"), RAW_SILVER)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else if 1.19.3 {
/*import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModItems {
    val SILVER_INGOT = Item(FabricItemSettings())
    val SILVER_NUGGET = Item(FabricItemSettings())
    val RAW_SILVER = Item(FabricItemSettings())
    val SILVER_ORE = BlockItem(ModBlocks.SILVER_ORE, FabricItemSettings())
    val DEEPSLATE_SILVER_ORE = BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE, FabricItemSettings())
    val SILVER_BLOCK = BlockItem(ModBlocks.SILVER_BLOCK, FabricItemSettings())

    val ITEM_GROUP = FabricItemGroup.builder(getIdentifier("item_group"))
        .title(net.minecraft.network.chat.Component.translatable("yjas.item_group"))
        .icon { ItemStack(SILVER_INGOT) }
        .displayItems { _, entries, _ ->
            entries.accept(SILVER_INGOT)
            entries.accept(SILVER_NUGGET)
            entries.accept(SILVER_BLOCK)
            entries.accept(RAW_SILVER)
            entries.accept(SILVER_ORE)
            entries.accept(DEEPSLATE_SILVER_ORE)
        }
        .build()

    fun register() {
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_nugget"), SILVER_NUGGET)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("raw_silver"), RAW_SILVER)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.ITEM, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else if 1.19.2 {
/*import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModItems {
    val ITEM_GROUP = FabricItemGroupBuilder.create(getIdentifier("item_group"))
        .icon { ItemStack(SILVER_INGOT) }
        .appendItems { stacks ->
            stacks.add(ItemStack(SILVER_INGOT))
            stacks.add(ItemStack(SILVER_NUGGET))
            stacks.add(ItemStack(SILVER_BLOCK))
            stacks.add(ItemStack(RAW_SILVER))
            stacks.add(ItemStack(SILVER_ORE))
            stacks.add(ItemStack(DEEPSLATE_SILVER_ORE))
        }
        .build()

    val SILVER_INGOT: Item = Item(FabricItemSettings().group(ITEM_GROUP))
    val SILVER_NUGGET: Item = Item(FabricItemSettings().group(ITEM_GROUP))
    val RAW_SILVER: Item = Item(FabricItemSettings().group(ITEM_GROUP))
    val SILVER_ORE: Item = BlockItem(ModBlocks.SILVER_ORE, FabricItemSettings().group(ITEM_GROUP))
    val DEEPSLATE_SILVER_ORE: Item = BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE, FabricItemSettings().group(ITEM_GROUP))
    val SILVER_BLOCK: Item = BlockItem(ModBlocks.SILVER_BLOCK, FabricItemSettings().group(ITEM_GROUP))

    fun register() {
        Registry.register(Registry.ITEM, getIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(Registry.ITEM, getIdentifier("silver_nugget"), SILVER_NUGGET)
        Registry.register(Registry.ITEM, getIdentifier("raw_silver"), RAW_SILVER)
        Registry.register(Registry.ITEM, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(Registry.ITEM, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(Registry.ITEM, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else {
/*import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModItems {
    val SILVER_INGOT = Item(FabricItemSettings().tab(CreativeModeTab.TAB_MISC))
    val SILVER_NUGGET = Item(FabricItemSettings().tab(CreativeModeTab.TAB_MISC))
    val RAW_SILVER = Item(FabricItemSettings().tab(CreativeModeTab.TAB_MISC))
    val SILVER_ORE = BlockItem(ModBlocks.SILVER_ORE, FabricItemSettings().tab(CreativeModeTab.TAB_MISC))
    val DEEPSLATE_SILVER_ORE = BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE, FabricItemSettings().tab(CreativeModeTab.TAB_MISC))
    val SILVER_BLOCK = BlockItem(ModBlocks.SILVER_BLOCK, FabricItemSettings().tab(CreativeModeTab.TAB_MISC))

    fun register() {
        Registry.register(Registry.ITEM, getIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(Registry.ITEM, getIdentifier("silver_nugget"), SILVER_NUGGET)
        Registry.register(Registry.ITEM, getIdentifier("raw_silver"), RAW_SILVER)
        Registry.register(Registry.ITEM, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(Registry.ITEM, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(Registry.ITEM, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?}
