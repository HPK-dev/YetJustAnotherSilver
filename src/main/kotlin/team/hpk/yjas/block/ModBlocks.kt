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

    private val SILVER_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK, getIdentifier("silver_block"))
    private val SILVER_ORE_KEY = RegistryKey.of(RegistryKeys.BLOCK, getIdentifier("silver_ore"))
    private val DEEPSLATE_SILVER_ORE_KEY = RegistryKey.of(RegistryKeys.BLOCK, getIdentifier("deepslate_silver_ore"))

    val SILVER_BLOCK: Block = Block(
        AbstractBlock.Settings
            .create()
            .registryKey(SILVER_BLOCK_KEY)
            .strength(4.0f)
            .requiresTool()
    )

    val SILVER_ORE: Block = Block(
        AbstractBlock.Settings
            .create()
            .registryKey(SILVER_ORE_KEY)
            .strength(3.0f)
            .requiresTool()
    )

    val DEEPSLATE_SILVER_ORE: Block = Block(
        AbstractBlock.Settings
            .create()
            .registryKey(DEEPSLATE_SILVER_ORE_KEY)
            .strength(4.5f)
            .requiresTool()
    )


    fun register() {
        Registry.register(
            Registries.BLOCK,
            SILVER_BLOCK_KEY,
            SILVER_BLOCK
        )

        Registry.register(
            Registries.BLOCK,
            SILVER_ORE_KEY,
            SILVER_ORE
        )

        Registry.register(
            Registries.BLOCK,
            DEEPSLATE_SILVER_ORE_KEY,
            DEEPSLATE_SILVER_ORE
        )


    }
}
