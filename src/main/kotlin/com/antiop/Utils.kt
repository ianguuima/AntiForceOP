package com.antiop

class Utils {

    companion object {

        fun getString(config: String): String{
            return AntiOP.INSTANCE.config.getString(config).replace("&", "§")
        }

        fun getStringList(config: String): List<String> {
            return AntiOP.INSTANCE.config.getStringList(config).map {
                    t -> t.replace("&", "§")
            }
        }

        fun isMessage(messageToBeBlocked : String, vararg message: String) : Boolean{
            for (t in message){
                if (t.equals(messageToBeBlocked, true)) return true
            }
            return false
        }

    }


}