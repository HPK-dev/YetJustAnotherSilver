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
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.registry.Registry
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks


object ModItems {

    val SILVER_INGOT = SilverIngot(FabricItemSettings().group(ItemGroup.MISC))
    val SILVER_NUGGET = SilverNugget(FabricItemSettings().group(ItemGroup.MISC))
    val RAW_SILVER = RawSilver(FabricItemSettings().group(ItemGroup.MISC))

    // Block items
    val SILVER_ORE = BlockItem(ModBlocks.SILVER_ORE, FabricItemSettings().group(ItemGroup.MISC))
    val DEEPSLATE_SILVER_ORE = BlockItem(ModBlocks.DEEPSLATE_SILVER_ORE, FabricItemSettings().group(ItemGroup.MISC))
    val SILVER_BLOCK = BlockItem(ModBlocks.SILVER_BLOCK, FabricItemSettings().group(ItemGroup.MISC))


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
