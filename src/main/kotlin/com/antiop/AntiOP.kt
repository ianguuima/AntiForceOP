package com.antiop

import com.antiop.commands.MainCommand
import com.antiop.listener.PlayerEvents
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin


class AntiOP : JavaPlugin() {

    lateinit var PLAYERS : HashSet<String>

    companion object {
        lateinit var INSTANCE : AntiOP
    }

    override fun onEnable() {
        INSTANCE = this
        loadConfig()
        PLAYERS = HashSet(config.getStringList("PermissionList"))


        registerEvents()
        registerCommands()
    }

    private fun loadConfig(){
        config.options().copyDefaults(false)
        saveDefaultConfig()
    }


    private fun registerEvents(){
       Bukkit.getPluginManager().registerEvents(PlayerEvents(), this)
    }

    private fun registerCommands(){
        getCommand("antiop").executor = MainCommand()
    }

}