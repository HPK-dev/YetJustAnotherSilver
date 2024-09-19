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

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import team.hpk.yjas.item.ModItems
import java.util.function.Consumer

class Recipe(output: FabricDataGenerator) : FabricRecipeProvider(output) {

    companion object {
        private val SILVER_MELTABLE = listOf(
            ModItems.SILVER_ORE,
            ModItems.DEEPSLATE_SILVER_ORE,
            ModItems.RAW_SILVER
        )
    }

    override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        offerSmelting(
            exporter, SILVER_MELTABLE,
             ModItems.SILVER_INGOT,
            1.0f, 200, "silver"
        )

        offerBlasting(
            exporter, SILVER_MELTABLE, ModItems.SILVER_INGOT,
            1.0f, 200, "silver"
        )

        offerReversibleCompactingRecipesWithCompactingRecipeGroup(
            exporter,
             ModItems.SILVER_INGOT,
             ModItems.SILVER_BLOCK,
            "silver_block_from_ingot","silver"
        )

        offerReversibleCompactingRecipesWithCompactingRecipeGroup(
            exporter,
             ModItems.SILVER_NUGGET,
             ModItems.SILVER_INGOT,
            "silver_ingot_from_nugget","silver"
        )


    }
}