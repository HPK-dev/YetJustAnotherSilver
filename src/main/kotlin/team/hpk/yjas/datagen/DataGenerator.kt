package team.hpk.yjas.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistryBuilder
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import team.hpk.yjas.world.ConfiguredFeatures
import team.hpk.yjas.world.PlacedFeatures

object DataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        fabricDataGenerator.createPack().apply {
            addProvider(::Item)
            addProvider(::Block)
            addProvider(::LootTable)
            addProvider(::Recipe)
            addProvider(::WorldGen)

        }
    }

    override fun buildRegistry(registryBuilder: RegistryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatures::boostrap)
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatures::boostrap)
    }

}

