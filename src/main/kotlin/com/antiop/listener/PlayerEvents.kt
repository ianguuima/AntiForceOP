package com.antiop.listener

import com.antiop.AntiOP
import com.antiop.Utils
import com.antiop.api.PlayerTryToGetOpEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerJoinEvent

class PlayerEvents : Listener {


    @EventHandler
    fun onJoin(e : PlayerJoinEvent){
        val p = e.player

        if (!p.isOp) return
        if (AntiOP.INSTANCE.PLAYERS.contains(p.name)) return

        p.kickPlayer(Utils.getString("Messages.kick"))
    }

    @EventHandler
    fun onPlayerGetOp(e : PlayerCommandPreprocessEvent){
        val p = e.player

        if (Utils.isMessage(e.message, "/minecraft:op", "/op")){

            val event = PlayerTryToGetOpEvent(p, false)

            if (!AntiOP.INSTANCE.PLAYERS.contains(p.name)) {
                p.kickPlayer(Utils.getString("Messages.tried"))
            } else event.hasSuccess = true

            Bukkit.getPluginManager().callEvent(event)
        }
    }


}