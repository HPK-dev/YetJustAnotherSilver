package team.hpk.yjas.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import team.hpk.yjas.datagen.ModTags.Items.INGOTS
import team.hpk.yjas.datagen.ModTags.Items.NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.ORES
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_DEEPSLATE
import team.hpk.yjas.datagen.ModTags.Items.ORES_IN_GROUND_STONE
import team.hpk.yjas.datagen.ModTags.Items.RAW_ORES
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER
import team.hpk.yjas.datagen.ModTags.Items.RAW_SILVER_ORES
import team.hpk.yjas.datagen.ModTags.Items.SILVER_BLOCKS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_INGOTS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_NUGGETS
import team.hpk.yjas.datagen.ModTags.Items.SILVER_ORES
import team.hpk.yjas.item.ModItems
import java.util.concurrent.CompletableFuture

class Item(output: FabricDataOutput, completableFuture: CompletableFuture<WrapperLookup>) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {


    override fun configure(arg: WrapperLookup) {
        getOrCreateTagBuilder(ORES)
            .addTag(SILVER_ORES)

        getOrCreateTagBuilder(SILVER_ORES)
            .add(ModItems.DEEPSLATE_SILVER_ORE)
            .add(ModItems.SILVER_ORE)

        getOrCreateTagBuilder(SILVER_BLOCKS)
            .add(ModItems.SILVER_BLOCK)

        getOrCreateTagBuilder(RAW_ORES)
            .addTag(RAW_SILVER_ORES)

//        getOrCreateTagBuilder(RAW_SILVER)
//            .add(ModItems.RAW_SILVER)

        getOrCreateTagBuilder(ORES_IN_GROUND_DEEPSLATE)
            .add(ModItems.DEEPSLATE_SILVER_ORE)

        getOrCreateTagBuilder(ORES_IN_GROUND_STONE)
            .add(ModItems.SILVER_ORE)

        getOrCreateTagBuilder(INGOTS)
            .addTag(SILVER_INGOTS)

        getOrCreateTagBuilder(NUGGETS)
            .addTag(SILVER_NUGGETS)

        getOrCreateTagBuilder(SILVER_INGOTS)
            .add(ModItems.SILVER_INGOT)

        getOrCreateTagBuilder(SILVER_NUGGETS)
            .add(ModItems.SILVER_NUGGET)

        getOrCreateTagBuilder(RAW_SILVER_ORES)
            .add(ModItems.RAW_SILVER)
    }
}