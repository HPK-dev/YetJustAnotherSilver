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
