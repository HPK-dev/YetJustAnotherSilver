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

import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import team.hpk.yjas.Utils.getIdentifier

class ModPlacedFeatures {

    companion object {
        val SILVER_ORE_PLACED_KEY: RegistryKey<PlacedFeature> = RegistryKey.of(
            net.minecraft.util.registry.Registry.PLACED_FEATURE_KEY,
            getIdentifier("silver_ore_placed")
        )

        val SILVER_ORE_PLACED = BuiltinRegistries.add(
                BuiltinRegistries.PLACED_FEATURE,
                SILVER_ORE_PLACED_KEY,
                PlacedFeature(
                    ModConfiguredFeatures.SILVER_ORE,
                    ModOrePlacements.modifiersWithCount(
                        8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-63), YOffset.fixed(40))
                    )
                )
            )
    }
}
