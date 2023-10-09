package me.ilgroggo.cooldownsplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class HealCommand implements CommandExecutor {
    // key = Player UUID
    // value = Cooldown
    private final HashMap<UUID, Long> cooldown;

    public HealCommand(){
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){

            Player p = (Player) commandSender;

            if(!this.cooldown.containsKey(p.getUniqueId())){

                this.cooldown.put(p.getUniqueId(), System.currentTimeMillis()); // use epoch time

                p.setHealth(20);
                p.sendMessage(ChatColor.GREEN + "You have been fully healed!");

            }else{

                long timeElapsed = System.currentTimeMillis() - cooldown.get(p.getUniqueId()); // time in milliseconds

                if(timeElapsed >= 10000){ // 10 seconds = 10'000 milliseconds

                    this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                    p.setHealth(20);
                    p.sendMessage(ChatColor.GREEN + "You have been fully healed!");


                }else{

                    p.sendMessage(ChatColor.RED + "Please wait 10 seconds to run again this command.");

                }

            }

        }


        return true;
    }
}
