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

    private fun create(name: String, strength: Float): Block {
        val key = RegistryKey.of(RegistryKeys.BLOCK, getIdentifier(name))
        return Block(
            AbstractBlock.Settings.create()
                .registryKey(key)
                .strength(strength)
                .requiresTool()
        )
    }

    val SILVER_BLOCK = create("silver_block", 4.0f)
    val SILVER_ORE = create("silver_ore", 3.0f)
    val DEEPSLATE_SILVER_ORE = create("deepslate_silver_ore", 4.5f)

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
