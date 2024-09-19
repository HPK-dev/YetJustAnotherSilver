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

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.util.registry.Registry
import team.hpk.yjas.Utils.getIdentifier


object ModBlocks {

    val SILVER_BLOCK: Block = Block(
        FabricBlockSettings
            .of(Material.METAL)
            .strength(4.0f)
            .requiresTool()
    )

    val SILVER_ORE: Block = Block(
        FabricBlockSettings
            .of(Material.STONE)
            .strength(3.0f)
            .requiresTool()
    )

    val DEEPSLATE_SILVER_ORE: Block = Block(
        FabricBlockSettings
            .of(Material.STONE)
            .strength(4.5f)
            .requiresTool()
    )


    fun register() {
        Registry.register(
            Registry.BLOCK,
            getIdentifier("silver_block"),
            SILVER_BLOCK
        )

        Registry.register(
            Registry.BLOCK,
            getIdentifier("silver_ore"),
            SILVER_ORE
        )

        Registry.register(
            Registry.BLOCK,
            getIdentifier("deepslate_silver_ore"),
            DEEPSLATE_SILVER_ORE
        )


    }
}