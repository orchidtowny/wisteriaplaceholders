package site.remlit.blueb.wisteriaPlaceholders

import org.bukkit.plugin.java.JavaPlugin

class WisteriaPlaceholders : JavaPlugin() {

    override fun onEnable() {
        instance = this

        if (instance.server.pluginManager.getPlugin("PlaceholderAPI") != null) {
            instance.logger.info("Registering PlaceholderAPI integration")
            PlaceholderExpansion().register()
        }

        instance.config.addDefault("tag.pre", "")
        instance.config.addDefault("tag.post", " <dark_gray>• %luckperms_meta_namecolor%")
        config.options().copyDefaults(true)
        saveConfig()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object {
        lateinit var instance: WisteriaPlaceholders
    }
}
