package team.hpk.yjas

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.item.ItemGroup
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.PlacedFeature
import team.hpk.yjas.ModMain.MOD_ID
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.BlockRegistry
import team.hpk.yjas.item.ItemRegistry


class Registry {
    companion object {

        val SILVER_ORE_PLACED: RegistryKey<PlacedFeature> = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, getIdentifier(
                "silver_ore"
            )
        )

        val ITEM_GROUP: RegistryKey<ItemGroup> = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier(MOD_ID, "item_group")
        )
    }

    init {
        ItemRegistry()
        BlockRegistry()
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            SILVER_ORE_PLACED
        )
    }
}