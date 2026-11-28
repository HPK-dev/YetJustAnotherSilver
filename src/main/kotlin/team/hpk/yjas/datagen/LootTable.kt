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

//? if >=26.3 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider
import net.minecraft.core.HolderLookup
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders
import java.util.concurrent.CompletableFuture
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class LootTable(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootSubProvider(output, registriesFuture) {

    private fun oreLikeDrops(drop: Block, item: ItemLike, minDropCount: Int, maxDropCount: Int): LootTable.Builder {
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDropCount, maxDropCount)))
                    .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generate() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(ModBlocks.SILVER_ORE, oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER, 2, 4))
        add(ModBlocks.DEEPSLATE_SILVER_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER, 2, 4))
    }
}
//?} else if >=26.1 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider
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

class LootTable(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootSubProvider(output, registriesFuture) {
    private fun oreLikeDrops(drop: Block, item: ItemLike): LootTable.Builder {
        val enchantments = registries.lookupOrThrow(Registries.ENCHANTMENT)
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))
                    .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generate() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(ModBlocks.SILVER_ORE, oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER))
        add(ModBlocks.DEEPSLATE_SILVER_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER))
    }
}
*///?} else if >=1.21 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
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
    private fun oreLikeDrops(drop: Block, item: ItemLike): LootTable.Builder {
        val enchantments = registries.lookupOrThrow(Registries.ENCHANTMENT)
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))
                    .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generate() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(ModBlocks.SILVER_ORE, oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER))
        add(ModBlocks.DEEPSLATE_SILVER_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER))
    }
}
*///?} else if >=1.20.5 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.core.HolderLookup
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
    private fun oreLikeDrops(drop: Block, item: ItemLike): LootTable.Builder {
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generate() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(ModBlocks.SILVER_ORE, oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER))
        add(ModBlocks.DEEPSLATE_SILVER_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER))
    }
}
*///?} else if >=1.19.4 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class LootTable(output: FabricDataOutput) : FabricBlockLootTableProvider(output) {
    private fun oreLikeDrops(drop: Block, item: ItemLike): LootTable.Builder {
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generate() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(ModBlocks.SILVER_ORE, oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER))
        add(ModBlocks.DEEPSLATE_SILVER_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER))
    }
}
*///?} else if 1.19.3 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class LootTable(output: FabricDataOutput) : FabricBlockLootTableProvider(output) {
    override fun accept(
        exporter: java.util.function.BiConsumer<net.minecraft.resources.ResourceLocation, net.minecraft.world.level.storage.loot.LootTable.Builder>
    ) {
        generate(exporter)
    }

    private fun oreDrops(drop: Block, item: ItemLike): net.minecraft.world.level.storage.loot.LootTable.Builder {
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generate() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(ModBlocks.SILVER_ORE, oreDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER))
        add(ModBlocks.DEEPSLATE_SILVER_ORE, oreDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER))
    }
}
*///?} else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class LootTable(output: FabricDataGenerator) : FabricBlockLootTableProvider(output) {
    private fun oreLikeDrops(drop: Block, item: ItemLike): LootTable.Builder {
        return createSilkTouchDispatchTable(
            drop,
            applyExplosionDecay(
                drop,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }

    override fun generateBlockLootTables() {
        dropSelf(ModBlocks.SILVER_BLOCK)
        add(ModBlocks.SILVER_ORE, oreLikeDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER))
        add(ModBlocks.DEEPSLATE_SILVER_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER))
    }
}
*///?}
