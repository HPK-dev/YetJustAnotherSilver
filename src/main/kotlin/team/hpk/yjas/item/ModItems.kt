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

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
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

    private val ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB,
        getIdentifier("item_group")
    )

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
