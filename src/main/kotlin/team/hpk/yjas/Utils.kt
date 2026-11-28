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

package team.hpk.yjas

//? if >=1.21.11 {
import net.minecraft.network.chat.Component
import net.minecraft.resources.Identifier
//?} else {
/*import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
*///?}
import team.hpk.yjas.ModMain.MOD_ID

object Utils {

    fun getTranslatableKey(identifier: String): Component {
        return Component.translatable("$MOD_ID.$identifier")
    }

    //? if >=1.21.11 {
    fun getIdentifier(identifier: String): Identifier {
        return Identifier.fromNamespaceAndPath(MOD_ID, identifier)
    }
    //?} else if >=1.21 {
    /*fun getIdentifier(identifier: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, identifier)
    }
    *///?} else {
    /*fun getIdentifier(identifier: String): ResourceLocation {
        return ResourceLocation(MOD_ID, identifier)
    }
    *///?}
}
