package team.hpk.yjas.world

import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.BlockTags
import net.minecraft.structure.rule.TagMatchRuleTest
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks


class ModConfiguredFeatures {
    companion object {

        val SILVER_ORE_KEY: RegistryKey<ConfiguredFeature<*, *>> =
            RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, getIdentifier("silver_ore"))

        fun boostrap(context: Registerable<ConfiguredFeature<*, *>>) {
            val stoneReplaceables = TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES)
            val deepslateReplaceables = TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)

            val silverOres = listOf(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SILVER_ORE.defaultState),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SILVER_ORE.defaultState)
            )


            context.register(
                SILVER_ORE_KEY,
                ConfiguredFeature(Feature.ORE, OreFeatureConfig(silverOres, 8))
            )

        }
    }




}