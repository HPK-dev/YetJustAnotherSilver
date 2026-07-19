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


    private val SILVER_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, getIdentifier("silver_ingot"))
    private val SILVER_NUGGET_KEY = RegistryKey.of(RegistryKeys.ITEM, getIdentifier("silver_nugget"))
    private val RAW_SILVER_KEY = RegistryKey.of(RegistryKeys.ITEM, getIdentifier("raw_silver"))
    private val SILVER_ORE_KEY = RegistryKey.of(RegistryKeys.ITEM, getIdentifier("silver_ore"))
    private val DEEPSLATE_SILVER_ORE_KEY = RegistryKey.of(RegistryKeys.ITEM, getIdentifier("deepslate_silver_ore"))
    private val SILVER_BLOCK_KEY = RegistryKey.of(RegistryKeys.ITEM, getIdentifier("silver_block"))

    val SILVER_INGOT = SilverIngot(Item.Settings().registryKey(SILVER_INGOT_KEY))
    val SILVER_NUGGET = SilverNugget(Item.Settings().registryKey(SILVER_NUGGET_KEY))
    val RAW_SILVER = RawSilver(Item.Settings().registryKey(RAW_SILVER_KEY))

    // Block items
    val SILVER_ORE = BlockItem(ModBlocks.SILVER_ORE, Item.Settings().registryKey(SILVER_ORE_KEY).useBlockPrefixedTranslationKey())
    val DEEPSLATE_SILVER_ORE = BlockItem(
        ModBlocks.DEEPSLATE_SILVER_ORE,
        Item.Settings().registryKey(DEEPSLATE_SILVER_ORE_KEY).useBlockPrefixedTranslationKey()
    )
    val SILVER_BLOCK = BlockItem(ModBlocks.SILVER_BLOCK, Item.Settings().registryKey(SILVER_BLOCK_KEY).useBlockPrefixedTranslationKey())


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
            SILVER_INGOT_KEY,
            SILVER_INGOT
        )

        Registry.register(
            Registries.ITEM,
            SILVER_NUGGET_KEY,
            SILVER_NUGGET
        )

        Registry.register(
            Registries.ITEM,
            RAW_SILVER_KEY,
            RAW_SILVER
        )

        // For block items

        Registry.register(
            Registries.ITEM,
            SILVER_BLOCK_KEY,
            SILVER_BLOCK
        )

        Registry.register(
            Registries.ITEM,
            SILVER_ORE_KEY,
            SILVER_ORE
        )

        Registry.register(
            Registries.ITEM,
            DEEPSLATE_SILVER_ORE_KEY,
            DEEPSLATE_SILVER_ORE
        )

    }
}


class SilverIngot(settings: Settings) : Item(settings)
class SilverNugget(settings: Settings) : Item(settings)
class RawSilver(settings: Settings) : Item(settings)
