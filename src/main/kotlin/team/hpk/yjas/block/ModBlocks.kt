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

package team.hpk.yjas.block

//? if >=26.2 {
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.references.BlockItemId
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    val SILVER_BLOCK_ID = blockItemId("silver_block")
    val SILVER_ORE_ID = blockItemId("silver_ore")
    val DEEPSLATE_SILVER_ORE_ID = blockItemId("deepslate_silver_ore")

    val SILVER_BLOCK = register(SILVER_BLOCK_ID.block(), 4.0f)
    val SILVER_ORE = register(SILVER_ORE_ID.block(), 3.0f)
    val DEEPSLATE_SILVER_ORE = register(DEEPSLATE_SILVER_ORE_ID.block(), 4.5f)

    private fun blockItemId(name: String): BlockItemId {
        val identifier = getIdentifier(name)
        return BlockItemId.create(identifier, identifier)
    }

    private fun register(key: ResourceKey<Block>, strength: Float): Block {
        val block = Block(
            BlockBehaviour.Properties.of()
                .strength(strength)
                .requiresCorrectToolForDrops()
                .setId(key)
        )
        return Registry.register(BuiltInRegistries.BLOCK, key, block)
    }

    fun initialize() = Unit
}
//?} else if >=1.21.11 {
/*import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    val SILVER_BLOCK = register("silver_block", 4.0f)
    val SILVER_ORE = register("silver_ore", 3.0f)
    val DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", 4.5f)

    private fun register(name: String, strength: Float): Block {
        val key = ResourceKey.create(Registries.BLOCK, getIdentifier(name))
        val block = Block(
            BlockBehaviour.Properties.of()
                .strength(strength)
                .requiresCorrectToolForDrops()
                .setId(key)
        )
        return Registry.register(BuiltInRegistries.BLOCK, key, block)
    }

    fun initialize() = Unit
}
*///?} else if >=1.21.6 {
/*import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    private fun key(name: String) = ResourceKey.create(Registries.BLOCK, getIdentifier(name))

    val SILVER_BLOCK: Block = Block(props("silver_block", 4.0f))
    val SILVER_ORE: Block = Block(props("silver_ore", 3.0f))
    val DEEPSLATE_SILVER_ORE: Block = Block(props("deepslate_silver_ore", 4.5f))

    private fun props(name: String, strength: Float): BlockBehaviour.Properties =
        BlockBehaviour.Properties.of().setId(key(name)).strength(strength).requiresCorrectToolForDrops()

    fun register() {
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else if >=1.21.4 {
/*import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    val SILVER_BLOCK = register("silver_block", 4.0f)
    val SILVER_ORE = register("silver_ore", 3.0f)
    val DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", 4.5f)

    private fun register(name: String, strength: Float): Block {
        val key = ResourceKey.create(Registries.BLOCK, getIdentifier(name))
        val block = Block(
            BlockBehaviour.Properties.of().setId(key).strength(strength).requiresCorrectToolForDrops()
        )
        return Registry.register(BuiltInRegistries.BLOCK, key, block)
    }

    fun register() = Unit
}
*///?} else if >=1.21.2 {
/*import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    private fun key(name: String) = ResourceKey.create(Registries.BLOCK, getIdentifier(name))

    val SILVER_BLOCK: Block = Block(props(key("silver_block"), 4.0f))
    val SILVER_ORE: Block = Block(props(key("silver_ore"), 3.0f))
    val DEEPSLATE_SILVER_ORE: Block = Block(props(key("deepslate_silver_ore"), 4.5f))

    private fun props(id: ResourceKey<Block>, strength: Float): BlockBehaviour.Properties =
        BlockBehaviour.Properties.of().setId(id).strength(strength).requiresCorrectToolForDrops()

    fun register() {
        Registry.register(BuiltInRegistries.BLOCK, key("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, key("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.BLOCK, key("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else if >=1.20.5 {
/*import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    val SILVER_BLOCK: Block = Block(BlockBehaviour.Properties.of().strength(4.0f).requiresCorrectToolForDrops())
    val SILVER_ORE: Block = Block(BlockBehaviour.Properties.of().strength(3.0f).requiresCorrectToolForDrops())
    val DEEPSLATE_SILVER_ORE: Block = Block(BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops())

    fun register() {
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else if >=1.20 {
/*import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.level.block.Block
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    val SILVER_BLOCK: Block = Block(FabricBlockSettings.create().strength(4.0f).requiresCorrectToolForDrops())
    val SILVER_ORE: Block = Block(FabricBlockSettings.create().strength(3.0f).requiresCorrectToolForDrops())
    val DEEPSLATE_SILVER_ORE: Block = Block(FabricBlockSettings.create().strength(4.5f).requiresCorrectToolForDrops())

    fun register() {
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else if >=1.19.3 {
/*import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Material
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    val SILVER_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresCorrectToolForDrops())
    val SILVER_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresCorrectToolForDrops())
    val DEEPSLATE_SILVER_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresCorrectToolForDrops())

    fun register() {
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(BuiltInRegistries.BLOCK, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?} else {
/*import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Material
import team.hpk.yjas.Utils.getIdentifier

object ModBlocks {
    val SILVER_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresCorrectToolForDrops())
    val SILVER_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresCorrectToolForDrops())
    val DEEPSLATE_SILVER_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresCorrectToolForDrops())

    fun register() {
        Registry.register(Registry.BLOCK, getIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(Registry.BLOCK, getIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(Registry.BLOCK, getIdentifier("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE)
    }
}
*///?}
