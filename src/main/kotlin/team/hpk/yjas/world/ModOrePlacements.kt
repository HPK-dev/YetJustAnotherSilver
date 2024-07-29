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

import net.minecraft.world.gen.placementmodifier.*

class ModOrePlacements {
    companion object {

         private fun modifiers(
            countModifier: PlacementModifier,
            heightModifier: PlacementModifier
        ): List<PlacementModifier> =
            listOf(
                countModifier,
                SquarePlacementModifier.of(),
                heightModifier,
                BiomePlacementModifier.of()
            )


         fun modifiersWithCount(count: Int, heightModifier: PlacementModifier): List<PlacementModifier> =
            modifiers(CountPlacementModifier.of(count), heightModifier)


         fun modifiersWithRarity(chance: Int, heightModifier: PlacementModifier): List<PlacementModifier> =
            modifiers(RarityFilterPlacementModifier.of(chance), heightModifier)
    }



}