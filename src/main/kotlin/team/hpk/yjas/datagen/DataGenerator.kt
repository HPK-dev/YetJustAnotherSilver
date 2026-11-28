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

package team.hpk.yjas.datagen

//? if >=1.19.3 {
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import team.hpk.yjas.world.ModConfiguredFeatures
import team.hpk.yjas.world.ModPlacedFeatures

object DataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        fabricDataGenerator.createPack().apply {
            //? if 1.19.4 {
            /*val blockTags = addProvider(::Block)
            addProvider { output, registries -> Item(output, registries, blockTags) }
            *///?} else {
            addProvider(::Item)
            addProvider(::Block)
            //?}
            addProvider(::LootTable)
            addProvider(::Recipe)
            addProvider(::WorldGen)
            addProvider(::Model)
        }
    }

    override fun buildRegistry(registryBuilder: RegistrySetBuilder) {
        //? if >=26.3 {
        registryBuilder.add(Registries.FEATURE, ModConfiguredFeatures::bootstrap)
        //?} else {
        /*registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
        *///?}
        registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
    }
}
//?} else {
/*import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object DataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        fabricDataGenerator.addProvider(::Item)
        fabricDataGenerator.addProvider(::Block)
        fabricDataGenerator.addProvider(::LootTable)
        fabricDataGenerator.addProvider(::Recipe)
        fabricDataGenerator.addProvider(::Model)
    }
}
*///?}
