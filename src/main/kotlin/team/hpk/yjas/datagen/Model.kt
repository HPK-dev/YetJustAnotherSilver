package team.hpk.yjas.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.item.ModItems

class Model(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.apply {
            registerSimpleCubeAll(ModBlocks.SILVER_BLOCK)
            registerSimpleCubeAll(ModBlocks.SILVER_ORE)
            registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE)
        }
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.apply {
            register(ModItems.RAW_SILVER, Models.GENERATED)
            register(ModItems.SILVER_INGOT, Models.GENERATED)
            register(ModItems.SILVER_NUGGET, Models.GENERATED)

        }
    }

}