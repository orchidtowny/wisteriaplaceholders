package site.remlit.blueb.wisteriaPlaceholders

import me.clip.placeholderapi.PlaceholderAPI
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.entity.Player

class PlaceholderExpansion : PlaceholderExpansion() {
    override fun getIdentifier(): String = "WisteriaPlaceholders"
    override fun getAuthor(): String = "blueb"
    override fun getVersion(): String = WisteriaPlaceholders.instance.pluginMeta.version

    private val config = WisteriaPlaceholders.instance.config

    private fun resolve(player: Player?, param: String?): String = PlaceholderAPI.setPlaceholders(player, param ?: "")

    override fun onPlaceholderRequest(player: Player?, params: String): String? {
        val split = params.split("_")
        when (split.first()) {
            "tag" -> {
                val tag = resolve(player, "%deluxetags_tag%")
                if (tag.isBlank()) return ""
                return "${resolve(player, config.getString("tag.pre"))}${tag}${resolve(player, config.getString("tag.post"))}"
            }
            else -> return null
        }
    }
}