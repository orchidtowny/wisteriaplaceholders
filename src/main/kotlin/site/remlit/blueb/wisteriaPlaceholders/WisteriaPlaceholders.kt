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
        instance.config.addDefault("tag.post", "")
        instance.config.addDefault("tag.replace", emptyList<String>())
        instance.config.addDefault("pronouns.pre", "&7(")
        instance.config.addDefault("pronouns.div", "/")
        instance.config.addDefault("pronouns.post", ")")
        instance.config.addDefault("pronouns.replace", emptyList<String>())
        instance.config.addDefault("rswc.ifw", "&7%rs_temperature% &8•&7 %rs_month_asname%")
        instance.config.addDefault("rswc.e", "&7&oNo information for this world")
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
