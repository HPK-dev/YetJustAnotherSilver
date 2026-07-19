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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipe.CookingRecipeJsonBuilder
import net.minecraft.data.recipe.RecipeExporter
import net.minecraft.data.recipe.RecipeGenerator
import net.minecraft.item.ItemConvertible
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.book.RecipeCategory
import team.hpk.yjas.item.ModItems
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import team.hpk.yjas.Utils.getIdentifier
import java.util.concurrent.CompletableFuture

class Recipe(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricRecipeProvider(output, registriesFuture) {

    companion object {
        private val SILVER_MELTABLE: List<ItemConvertible> = listOf(
            ModItems.SILVER_ORE,
            ModItems.DEEPSLATE_SILVER_ORE,
            ModItems.RAW_SILVER
        )
    }

    override fun getRecipeGenerator(
        registryLookup: RegistryWrapper.WrapperLookup,
        exporter: RecipeExporter
    ): RecipeGenerator = object : RecipeGenerator(registryLookup, exporter) {
        override fun generate() {
            SILVER_MELTABLE.forEach { input ->
                offerCookingRecipe(input, false)
                offerCookingRecipe(input, true)
            }

            createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_BLOCK)
                .input('#', ModItems.SILVER_INGOT)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group("silver")
                .criterion(hasItem(ModItems.SILVER_INGOT), conditionsFromItem(ModItems.SILVER_INGOT))
                .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, getIdentifier("silver_block_from_ingot")))

            createShapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT, 9)
                .input(ModItems.SILVER_BLOCK)
                .criterion(hasItem(ModItems.SILVER_BLOCK), conditionsFromItem(ModItems.SILVER_BLOCK))
                .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, getIdentifier("silver_ingot")))

            createShaped(RecipeCategory.MISC, ModItems.SILVER_INGOT)
                .input('#', ModItems.SILVER_NUGGET)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group("silver")
                .criterion(hasItem(ModItems.SILVER_NUGGET), conditionsFromItem(ModItems.SILVER_NUGGET))
                .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, getIdentifier("silver_ingot_from_nugget")))

            createShapeless(RecipeCategory.MISC, ModItems.SILVER_NUGGET, 9)
                .input(ModItems.SILVER_INGOT)
                .criterion(hasItem(ModItems.SILVER_INGOT), conditionsFromItem(ModItems.SILVER_INGOT))
                .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, getIdentifier("silver_nugget")))
        }

        private fun offerCookingRecipe(input: ItemConvertible, blasting: Boolean) {
            val method = if (blasting) "blasting" else "smelting"
            val cookingTime = if (blasting) 100 else 200
            val recipe = if (blasting) {
                CookingRecipeJsonBuilder.createBlasting(
                    Ingredient.ofItem(input), RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, cookingTime
                )
            } else {
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(input), RecipeCategory.MISC, ModItems.SILVER_INGOT, 1.0f, cookingTime
                )
            }

            recipe.group("silver")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(
                    exporter,
                    RegistryKey.of(
                        RegistryKeys.RECIPE,
                        getIdentifier("silver_ingot_from_${method}_${getItemPath(input)}")
                    )
                )
        }
    }

    override fun getName() = "YJAS Recipes"
}
