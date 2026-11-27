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

//? if >=26.3 {
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.BlockReplacement
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.OreFeature
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModConfiguredFeatures {
    val SILVER_ORE_KEY: ResourceKey<Feature> =
        ResourceKey.create(Registries.FEATURE, getIdentifier("silver_ore"))

    fun bootstrap(context: BootstrapContext<Feature>) {
        context.register(
            SILVER_ORE_KEY,
            OreFeature(
                listOf(
                    BlockReplacement.replace(
                        TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                        ModBlocks.SILVER_ORE.defaultBlockState()
                    ),
                    BlockReplacement.replace(
                        TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                        ModBlocks.DEEPSLATE_SILVER_ORE.defaultBlockState()
                    )
                ),
                4
            )
        )
    }
}
//?} else if >=1.20.5 {
/*import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModConfiguredFeatures {
    val SILVER_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> =
        ResourceKey.create(Registries.CONFIGURED_FEATURE, getIdentifier("silver_ore"))

    fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {
        context.register(
            SILVER_ORE_KEY,
            ConfiguredFeature(
                Feature.ORE,
                OreConfiguration(
                    listOf(
                        OreConfiguration.target(
                            TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            ModBlocks.SILVER_ORE.defaultBlockState()
                        ),
                        OreConfiguration.target(
                            TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            ModBlocks.DEEPSLATE_SILVER_ORE.defaultBlockState()
                        )
                    ),
                    4
                )
            )
        )
    }
}
*///?} else if >=1.19.3 {
/*import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModConfiguredFeatures {
    val SILVER_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> =
        ResourceKey.create(Registries.CONFIGURED_FEATURE, getIdentifier("silver_ore"))

    fun bootstrap(context: BootstapContext<ConfiguredFeature<*, *>>) {
        context.register(
            SILVER_ORE_KEY,
            ConfiguredFeature(
                Feature.ORE,
                OreConfiguration(
                    listOf(
                        OreConfiguration.target(
                            TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            ModBlocks.SILVER_ORE.defaultBlockState()
                        ),
                        OreConfiguration.target(
                            TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            ModBlocks.DEEPSLATE_SILVER_ORE.defaultBlockState()
                        )
                    ),
                    4
                )
            )
        )
    }
}
*///?} else {
/*import net.minecraft.core.Registry
import net.minecraft.data.BuiltinRegistries
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import team.hpk.yjas.Utils.getIdentifier
import team.hpk.yjas.block.ModBlocks

object ModConfiguredFeatures {
    val SILVER_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = ResourceKey.create(
        Registry.CONFIGURED_FEATURE_REGISTRY,
        getIdentifier("silver_ore")
    )

    val SILVER_ORE = BuiltinRegistries.register(
        BuiltinRegistries.CONFIGURED_FEATURE,
        SILVER_ORE_KEY,
        ConfiguredFeature(
            Feature.ORE,
            OreConfiguration(
                listOf(
                    OreConfiguration.target(
                        TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                        ModBlocks.SILVER_ORE.defaultBlockState()
                    ),
                    OreConfiguration.target(
                        TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                        ModBlocks.DEEPSLATE_SILVER_ORE.defaultBlockState()
                    )
                ),
                4
            )
        )
    )
}
*///?}
