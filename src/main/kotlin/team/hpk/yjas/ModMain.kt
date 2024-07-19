package team.hpk.yjas

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory


object ModMain : ModInitializer {

    const val MOD_ID = "yjas"
    val LOGGER = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        LOGGER.info("We add silver to your game!")
     Registry()


    }
}