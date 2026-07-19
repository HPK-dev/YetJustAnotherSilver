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

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.registry.Registry
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks


object ModItems {

    val ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.create(getIdentifier("item_group"))
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


    val SILVER_INGOT = SilverIngot(FabricItemSettings().group(ITEM_GROUP))
    val SILVER_NUGGET = SilverNugget(FabricItemSettings().group(ITEM_GROUP))
    val RAW_SILVER = RawSilver(FabricItemSettings().group(ITEM_GROUP))

    // Block items
    val SILVER_ORE = BlockItem(ModBlocks.SILVER_ORE, FabricItemSettings().group(ITEM_GROUP))
    val DEEPSLATE_SILVER_ORE = BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE, FabricItemSettings().group(ITEM_GROUP))
    val SILVER_BLOCK = BlockItem(ModBlocks.SILVER_BLOCK, FabricItemSettings().group(ITEM_GROUP))


    fun register() {
        Registry.register(
            Registry.ITEM,
            getIdentifier("silver_ingot"),
            SILVER_INGOT
        )

        Registry.register(
            Registry.ITEM,
            getIdentifier("silver_nugget"),
            SILVER_NUGGET
        )

        Registry.register(
            Registry.ITEM,
            getIdentifier("raw_silver"),
            RAW_SILVER
        )

        // For block items

        Registry.register(
            Registry.ITEM,
            getIdentifier("silver_block"),
            SILVER_BLOCK
        )

        Registry.register(
            Registry.ITEM,
            getIdentifier("silver_ore"),
            SILVER_ORE
        )

        Registry.register(
            Registry.ITEM,
            getIdentifier("deepslate_silver_ore"),
            DEEPSLATE_SILVER_ORE
        )

    }
}


class SilverIngot(settings: Settings?) : Item(settings)
class SilverNugget(settings: Settings?) : Item(settings)
class RawSilver(settings: Settings?) : Item(settings)
