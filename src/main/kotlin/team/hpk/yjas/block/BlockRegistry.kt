package team.hpk.yjas.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import team.hpk.yjas.ModMain.MOD_ID
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.block.Block

class BlockRegistry {
    val SILVER_BLOCK: Block = Block(FabricBlockSettings.create().strength(4.0f))

    constructor() {
        Registry.register(
            Registries.BLOCK,
            Identifier(MOD_ID, "silver_block"),
            SILVER_BLOCK
        )
    }
}