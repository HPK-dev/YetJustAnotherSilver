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

package team.hpk.yjas.world

import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import team.hpk.yjas.Utils.getIdentifier

class ModPlacedFeatures {

    companion object {
        val SILVER_ORE_PLACED_KEY: RegistryKey<PlacedFeature> =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, getIdentifier("silver_ore_placed"))


        fun boostrap(context: Registerable<PlacedFeature>) {
            val configuredFeature = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
            context.register(
                SILVER_ORE_PLACED_KEY,
                PlacedFeature(
                    configuredFeature.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY),
                    ModOrePlacements.modifiersWithCount(
                        12 /*Veins per chunk*/,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(5), YOffset.fixed(40))
                    )

                )
            )
        }
    }
}