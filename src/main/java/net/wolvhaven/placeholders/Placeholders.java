package net.wolvhaven.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kitteh.vanish.VanishManager;
import org.kitteh.vanish.VanishPerms;
import org.kitteh.vanish.VanishPlugin;

public class Placeholders extends PlaceholderExpansion {
  @Override
  public @NotNull String getIdentifier() {
    return "wh";
  }

  @Override
  public @NotNull String getAuthor() {
    return "Underscore11";
  }

  @Override
  public @NotNull String getVersion() {
    return "null";
  }

  @Override
  public String onPlaceholderRequest(final Player player, @NotNull final String params) {
    if (player == null) return "";
    if (params.equals("online")) {
      if (VanishPerms.canSeeAll(player) && getVanishManager().numVanished() != 0) {
        return String.format("&f%s&b/%s&f/%s",
                Bukkit.getOnlinePlayers().size() - getVanishManager().numVanished(),
                getVanishManager().numVanished(),
                Bukkit.getMaxPlayers()
        );
      } else {
        return String.format("&f%s/%s",
                Bukkit.getOnlinePlayers().size() - getVanishManager().numVanished(),
                Bukkit.getMaxPlayers()
        );
      }
    }

    if (params.equals("isvanished")) {
      if (getVanishManager().isVanished(player)) {
        return "&b[V]";
      } else {
        return "";
      }
    }

    return "";
  }

  public VanishManager getVanishManager() {
    return VanishPlugin.getPlugin(VanishPlugin.class).getManager();
  }
}
