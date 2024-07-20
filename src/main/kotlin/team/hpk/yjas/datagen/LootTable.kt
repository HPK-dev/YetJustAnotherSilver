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

