package team.hpk.yjas

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object YetJustAnotherSliver : ModInitializer {
	val modid = "yet-just-another-sliver"
    private val logger = LoggerFactory.getLogger(modid)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
	}
}