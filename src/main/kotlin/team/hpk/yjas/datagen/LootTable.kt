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

package team.hpk.yjas.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.ItemConvertible
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LootPoolEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class LootTable(output: FabricDataOutput) : FabricBlockLootTableProvider(output) {


    private fun oreLikeDrops(
        drop: Block, item: ItemConvertible, minDropCount: Float, maxDropCount: Float
    ): LootTable.Builder {
        return dropsWithSilkTouch(
            drop,
            applyExplosionDecay(
                drop,
                ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDropCount, maxDropCount)))
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            ) as LootPoolEntry.Builder<*>
        )
    }

    override fun generate() {
        addDrop(ModBlocks.SILVER_BLOCK)
        addDrop(
            ModBlocks.SILVER_ORE,
            oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER, 2.0f, 4.0f)
        )
        addDrop(
            ModBlocks.DEEPSLATE_SILVER_ORE,
            oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER, 2.0f, 4.0f)
        )


    }


}

