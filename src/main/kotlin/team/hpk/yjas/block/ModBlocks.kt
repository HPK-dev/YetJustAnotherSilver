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

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import team.hpk.yjas.Utils.getIdentifier


object ModBlocks {

    val SILVER_BLOCK = register("silver_block", 4.0f)
    val SILVER_ORE = register("silver_ore", 3.0f)
    val DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", 4.5f)

    private fun register(name: String, strength: Float): Block {
        val key = RegistryKey.of(RegistryKeys.BLOCK, getIdentifier(name))
        val block = Block(
            AbstractBlock.Settings.create()
                .registryKey(key)
                .strength(strength)
                .requiresTool()
        )
        return Registry.register(Registries.BLOCK, key, block)
    }

    fun register() = Unit
}
