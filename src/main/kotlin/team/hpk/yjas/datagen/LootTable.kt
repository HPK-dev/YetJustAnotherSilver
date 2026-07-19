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
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import java.util.concurrent.CompletableFuture
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class LootTable(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootTableProvider(output, registriesFuture) {

    private fun oreLikeDrops(
        drop: Block,
        item: ItemLike,
        minDropCount: Float,
        maxDropCount: Float
    ): LootTable.Builder {
        val enchantmentLookup = registries.lookupOrThrow(Registries.ENCHANTMENT)
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDropCount, maxDropCount)))
                    .apply(ApplyBonusCount.addOreBonusCount(enchantmentLookup.getOrThrow(Enchantments.FORTUNE)))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generate() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(
            ModBlocks.SILVER_ORE,
            oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER, 2.0f, 4.0f)
        )
        add(
            ModBlocks.DEEPSLATE_SILVER_ORE,
            oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER, 2.0f, 4.0f)
        )
    }
}
