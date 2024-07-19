package team.hpk.yjas

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory
import team.hpk.yjas.block.BlockRegistry
import team.hpk.yjas.item.ItemRegistry

object ModMain : ModInitializer {
	const val MOD_ID = "yet-just-another-silver"
    val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ItemRegistry()
		BlockRegistry()
	}
}