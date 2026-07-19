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
