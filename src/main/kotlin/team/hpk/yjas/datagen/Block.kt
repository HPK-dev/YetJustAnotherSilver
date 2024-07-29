package team.hpk.yjas.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.BlockTags
import team.hpk.yjas.block.ModBlocks
import team.hpk.yjas.datagen.ModTags.Blocks.BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.ORES
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Blocks.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Blocks.SILVER_ORES
import java.util.concurrent.CompletableFuture

open class Block(output: FabricDataOutput, completableFuture: CompletableFuture<WrapperLookup>) :
    FabricTagProvider.BlockTagProvider(output, completableFuture) {


    override fun configure(arg: WrapperLookup) {
        getOrCreateTagBuilder(ORES)
            .addTag(SILVER_ORES)

//        getOrCreateTagBuilder(BLOCKS)
//            .addTag(SILVER_BLOCKS)
//            .addTag(SILVER_ORES)

        getOrCreateTagBuilder(SILVER_ORES)
            .add(ModBlocks.DEEPSLATE_SILVER_ORE)
            .add(ModBlocks.SILVER_ORE)

        getOrCreateTagBuilder(SILVER_BLOCKS)
            .add(ModBlocks.SILVER_BLOCK)

        getOrCreateTagBuilder(ORES_IN_GROUND_DEEPSLATE)
            .add(ModBlocks.DEEPSLATE_SILVER_ORE)

        getOrCreateTagBuilder(ORES_IN_GROUND_STONE)
            .add(ModBlocks.SILVER_ORE)

        // Minecraft vanilla tags
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .addTag(SILVER_ORES)
            .addTag(SILVER_BLOCKS)

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .addTag(SILVER_ORES)
            .addTag(SILVER_BLOCKS)
    }
}