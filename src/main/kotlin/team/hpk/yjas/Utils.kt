package team.hpk.yjas

import net.minecraft.text.Text
import net.minecraft.util.Identifier
import team.hpk.yjas.ModMain.MOD_ID

object Utils {

    fun getTranslatableKey(identifier: String): Text {
        return Text.translatable("$MOD_ID.$identifier")
    }

    fun getIdentifier (identifier: String) : Identifier {
        return Identifier(MOD_ID , identifier)
    }
}