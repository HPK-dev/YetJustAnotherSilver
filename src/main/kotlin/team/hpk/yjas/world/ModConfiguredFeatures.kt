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
                ConfiguredFeature(Feature.ORE, OreFeatureConfig(silverOres, 12))
            )

        }
    }




}