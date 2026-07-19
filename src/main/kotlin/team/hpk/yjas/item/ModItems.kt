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
        Identifier.of(MOD_ID, "item_group")
    )


    val SILVER_INGOT = registerItem("silver_ingot", ::SilverIngot)
    val SILVER_NUGGET = registerItem("silver_nugget", ::SilverNugget)
    val RAW_SILVER = registerItem("raw_silver", ::RawSilver)

    // Block items
    val SILVER_ORE = registerBlockItem("silver_ore", ModBlocks.SILVER_ORE)
    val DEEPSLATE_SILVER_ORE = registerBlockItem("deepslate_silver_ore", ModBlocks.DEEPSLATE_SILVER_ORE)
    val SILVER_BLOCK = registerBlockItem("silver_block", ModBlocks.SILVER_BLOCK)

    private fun registerItem(name: String, factory: (Item.Settings) -> Item): Item {
        val key = RegistryKey.of(RegistryKeys.ITEM, getIdentifier(name))
        return Registry.register(Registries.ITEM, key, factory(Item.Settings().registryKey(key)))
    }

    private fun registerBlockItem(name: String, block: net.minecraft.block.Block): BlockItem {
        val key = RegistryKey.of(RegistryKeys.ITEM, getIdentifier(name))
        val item = BlockItem(block, Item.Settings().registryKey(key).useBlockPrefixedTranslationKey())
        return Registry.register(Registries.ITEM, key, item)
    }

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
    }
}


class SilverIngot(settings: Settings) : Item(settings)
class SilverNugget(settings: Settings) : Item(settings)
class RawSilver(settings: Settings) : Item(settings)
