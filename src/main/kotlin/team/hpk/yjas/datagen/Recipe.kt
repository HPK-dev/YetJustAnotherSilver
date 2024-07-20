package team.hpk.yjas.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.recipe.book.RecipeCategory
import team.hpk.yjas.item.ModItems
import java.util.function.Consumer

class Recipe(output: FabricDataOutput) : FabricRecipeProvider(output) {

    companion object {
        private val SILVER_MELTABLE = listOf(
            ModItems.SILVER_ORE,
            ModItems.DEEPSLATE_SILVER_ORE,
            ModItems.RAW_SILVER
        )
    }

    override fun generate(exporter: Consumer<RecipeJsonProvider>) {
        offerSmelting(
            exporter, SILVER_MELTABLE,
            RecipeCategory.MISC, ModItems.SILVER_INGOT,
            1.0f, 200, "silver"
        )

        offerBlasting(
            exporter, SILVER_MELTABLE, RecipeCategory.MISC, ModItems.SILVER_INGOT,
            1.0f, 200, "silver"
        )

        offerReversibleCompactingRecipesWithCompactingRecipeGroup(
            exporter,
            RecipeCategory.MISC, ModItems.SILVER_INGOT,
            RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK,
            "silver_block_from_ingot","silver"
        )

        offerReversibleCompactingRecipesWithCompactingRecipeGroup(
            exporter,
            RecipeCategory.MISC, ModItems.SILVER_NUGGET,
            RecipeCategory.MISC, ModItems.SILVER_INGOT,
            "silver_ingot_from_nugget","silver"
        )


    }
}