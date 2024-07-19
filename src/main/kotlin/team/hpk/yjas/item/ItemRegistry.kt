package team.hpk.yjas.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import team.hpk.yjas.ModMain.MOD_ID

class ItemRegistry {
    val SILVER_INGOT = Registry.register(
        Registries.ITEM,
        Identifier(MOD_ID, "silver_ingot"),
        SilverIngot(FabricItemSettings())
    )
}