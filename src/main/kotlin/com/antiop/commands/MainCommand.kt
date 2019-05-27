package com.antiop.commands

import com.antiop.AntiOP
import com.antiop.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class MainCommand:CommandExecutor {


    override fun onCommand(
        s: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (command.name.equals("antiop", true)) {
            if (!s.hasPermission("antiop.use")){
                s.sendMessage(Utils.getString("Messages.nopermission"))
                return false
            }
            if (args.isEmpty() || args.size > 1) {
                s.sendMessage(" ")
                s.sendMessage("§cAntiOP - Plugin")
                s.sendMessage("/antiop reload - Reload the list")
                s.sendMessage("/antiop list - All players in list")
                s.sendMessage(" ")
            }

            if (args.size == 1) {

                if (args[0].equals("reload", true)) {
                    AntiOP.INSTANCE.reloadConfig()
                    AntiOP.INSTANCE.PLAYERS = HashSet(AntiOP.INSTANCE.config.getStringList("PermissionList"))
                    s.sendMessage(Utils.getString("Messages.reload"))
                }

                if (args[0].equals("list", true)) {
                    s.sendMessage(Utils.getString("Messages.list"))
                    s.sendMessage(AntiOP.INSTANCE.PLAYERS.joinToString {
                        it
                    })

                }
            }
        }
        return false
    }

}