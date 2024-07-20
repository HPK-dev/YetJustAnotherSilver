package team.hpk.yjas.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class WorldGen(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?) :
    FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun getName(): String {
        return "World Gen"
    }


    override fun configure(registries: RegistryWrapper.WrapperLookup, entries: Entries) {
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE))
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE))
    }
}