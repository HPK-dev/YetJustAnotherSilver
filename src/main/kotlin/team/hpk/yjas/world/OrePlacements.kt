package team.hpk.yjas.world

import net.minecraft.world.gen.placementmodifier.*

class OrePlacements {
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