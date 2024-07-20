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