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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.advancements.Advancement
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.world.item.crafting.CookingBookCategory
import net.minecraft.world.item.crafting.Recipe
import java.util.concurrent.CompletableFuture
import team.hpk.yjas.item.ModItems

class Recipe(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricRecipeProvider(output, registriesFuture) {

    companion object {
        private val SILVER_MELTABLE = listOf(
            ModItems.SILVER_ORE,
            ModItems.DEEPSLATE_SILVER_ORE,
            ModItems.RAW_SILVER
        )
    }

    override fun createRecipeProvider(
        registryLookup: HolderLookup.Provider,
        recipes: BootstrapContext<Recipe<*>>,
        advancements: BootstrapContext<Advancement>
    ): RecipeProvider =
        object : RecipeProvider(recipes, advancements) {
            override fun buildRecipes() {
                oreSmelting(SILVER_MELTABLE, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
                oreBlasting(SILVER_MELTABLE, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 100, "silver")
                nineBlockStorageRecipesWithCustomPacking(
                    RecipeCategory.MISC, ModItems.SILVER_INGOT,
                    RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK,
                    "silver_block_from_ingot", "silver"
                )
                nineBlockStorageRecipesWithCustomPacking(
                    RecipeCategory.MISC, ModItems.SILVER_NUGGET,
                    RecipeCategory.MISC, ModItems.SILVER_INGOT,
                    "silver_ingot_from_nugget", "silver"
                )
            }
        }

    override fun getName(): String = "Silver Recipes"
}
//?} else if >=26.1 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.world.item.crafting.CookingBookCategory
import java.util.concurrent.CompletableFuture
import team.hpk.yjas.item.ModItems

class Recipe(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricRecipeProvider(output, registriesFuture) {
    companion object {
        private val SILVER_MELTABLE = listOf(ModItems.SILVER_ORE, ModItems.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER)
    }

    override fun createRecipeProvider(registryLookup: HolderLookup.Provider, exporter: RecipeOutput): RecipeProvider =
        object : RecipeProvider(registryLookup, exporter) {
            override fun buildRecipes() {
                oreSmelting(SILVER_MELTABLE, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
                oreBlasting(SILVER_MELTABLE, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 100, "silver")
                nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC, ModItems.SILVER_INGOT, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK, "silver_block_from_ingot", "silver")
                nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC, ModItems.SILVER_NUGGET, RecipeCategory.MISC, ModItems.SILVER_INGOT, "silver_ingot_from_nugget", "silver")
            }
        }

    override fun getName(): String = "Silver Recipes"
}
*///?} else if >=1.21.2 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import java.util.concurrent.CompletableFuture
import team.hpk.yjas.item.ModItems

class Recipe(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricRecipeProvider(output, registriesFuture) {
    override fun createRecipeProvider(registryLookup: HolderLookup.Provider, exporter: RecipeOutput): RecipeProvider =
        object : RecipeProvider(registryLookup, exporter) {
            override fun buildRecipes() {
                val inputs = listOf(ModItems.SILVER_ORE, ModItems.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER)
                //? if >=1.21.4 <1.21.11 {
                /*oreSmelting(inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
                oreBlasting(inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 100, "silver")
                *///?} else {
                oreSmelting(inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
                oreBlasting(inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
                //?}
                nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC, ModItems.SILVER_INGOT, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK, "silver_block_from_ingot", "silver")
                nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC, ModItems.SILVER_NUGGET, RecipeCategory.MISC, ModItems.SILVER_INGOT, "silver_ingot_from_nugget", "silver")
            }
        }

    override fun getName(): String = "Silver Recipes"
}
*///?} else if >=1.20.5 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import java.util.concurrent.CompletableFuture
import team.hpk.yjas.item.ModItems

class Recipe(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricRecipeProvider(output, registriesFuture) {
    override fun buildRecipes(exporter: RecipeOutput) {
        val inputs = listOf(ModItems.SILVER_ORE, ModItems.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER)
        oreSmelting(exporter, inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        oreBlasting(exporter, inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, RecipeCategory.MISC, ModItems.SILVER_INGOT, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK, "silver_block_from_ingot", "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, RecipeCategory.MISC, ModItems.SILVER_NUGGET, RecipeCategory.MISC, ModItems.SILVER_INGOT, "silver_ingot_from_nugget", "silver")
    }
}
*///?} else if >=1.20.2 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import team.hpk.yjas.item.ModItems

class Recipe(output: FabricDataOutput) : FabricRecipeProvider(output) {
    override fun buildRecipes(exporter: RecipeOutput) {
        val inputs = listOf(ModItems.SILVER_ORE, ModItems.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER)
        oreSmelting(exporter, inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        oreBlasting(exporter, inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, RecipeCategory.MISC, ModItems.SILVER_INGOT, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK, "silver_block_from_ingot", "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, RecipeCategory.MISC, ModItems.SILVER_NUGGET, RecipeCategory.MISC, ModItems.SILVER_INGOT, "silver_ingot_from_nugget", "silver")
    }
}
*///?} else if >=1.19.3 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import team.hpk.yjas.item.ModItems
import java.util.function.Consumer

class Recipe(output: FabricDataOutput) : FabricRecipeProvider(output) {
    override fun buildRecipes(exporter: Consumer<FinishedRecipe>) {
        val inputs = listOf(ModItems.SILVER_ORE, ModItems.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER)
        oreSmelting(exporter, inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        oreBlasting(exporter, inputs, RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, RecipeCategory.MISC, ModItems.SILVER_INGOT, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK, "silver_block_from_ingot", "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, RecipeCategory.MISC, ModItems.SILVER_NUGGET, RecipeCategory.MISC, ModItems.SILVER_INGOT, "silver_ingot_from_nugget", "silver")
    }
}
*///?} else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipes.FinishedRecipe
import team.hpk.yjas.item.ModItems
import java.util.function.Consumer

class Recipe(output: FabricDataGenerator) : FabricRecipeProvider(output) {
    override fun generateRecipes(exporter: Consumer<FinishedRecipe>) {
        val inputs = listOf(ModItems.SILVER_ORE, ModItems.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER)
        oreSmelting(exporter, inputs, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        oreBlasting(exporter, inputs, ModItems.SILVER_INGOT, 1.0f, 200, "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, ModItems.SILVER_INGOT, ModItems.SILVER_BLOCK, "silver_block_from_ingot", "silver")
        nineBlockStorageRecipesWithCustomPacking(exporter, ModItems.SILVER_NUGGET, ModItems.SILVER_INGOT, "silver_ingot_from_nugget", "silver")
    }
}
*///?}
