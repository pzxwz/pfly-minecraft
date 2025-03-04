package br.com.pzsz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main m;

    @Override
    public void onLoad() {
        m = this;
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin iniciado");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin desligado");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cComando somente para players!");
            return false;
        }
        Player p = (Player) commandSender;
        if (!p.hasPermission("permission.fly")) {
            p.sendMessage("§cVocê não possui permissão para executar este comando!");
            return false;
        }
        if (!p.getAllowFlight()) {
            p.setAllowFlight(true);
            p.sendMessage("§eModo de fly alterado para §atrue.");
        } else {
            p.setAllowFlight(false);
            p.sendMessage("§eModo de fly alterado para §cfalse.");
        }
        return true;
    }
}