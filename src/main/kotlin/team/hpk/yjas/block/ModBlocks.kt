package team.hpk.yjas.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import team.hpk.yjas.Utils.getIdentifier


object ModBlocks {

    val SILVER_BLOCK: Block = Block(
        FabricBlockSettings
            .create()
            .strength(4.0f)
            .requiresTool()
    )

    val SILVER_ORE: Block = Block(
        FabricBlockSettings
            .create()
            .strength(3.0f)
            .requiresTool()
    )

    val DEEPSLATE_SILVER_ORE: Block = Block(
        FabricBlockSettings
            .create()
            .strength(4.5f)
            .requiresTool()
    )


    fun register() {
        Registry.register(
            Registries.BLOCK,
            getIdentifier("silver_block"),
            SILVER_BLOCK
        )

        Registry.register(
            Registries.BLOCK,
            getIdentifier("silver_ore"),
            SILVER_ORE
        )

        Registry.register(
            Registries.BLOCK,
            getIdentifier("deepslate_silver_ore"),
            DEEPSLATE_SILVER_ORE
        )


    }
}