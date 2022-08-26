package xyz.devmeko.MCPlugin.NameChanger;

import com.mojang.authlib.GameProfile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ChangeName {

    public static void changeName(String newName, Player player) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Method getHandle = player.getClass().getMethod("getHandle", (Class<?>[]) null);
        Object entityPlayer = getHandle.invoke(player);
        Class<?> entityHuman = entityPlayer.getClass().getSuperclass();
        Field bH = entityHuman.getDeclaredField("bH");
        bH.setAccessible(true);
        bH.set(entityPlayer, new GameProfile(player.getUniqueId(), newName));
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.hidePlayer(player);
            players.showPlayer(player);
        }
    }

    public static void revert(Player player) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Method getHandle = player.getClass().getMethod("getHandle", (Class<?>[]) null);
        Object entityPlayer = getHandle.invoke(player);
        Class<?> entityHuman = entityPlayer.getClass().getSuperclass();
        Field bH = entityHuman.getDeclaredField("bH");
        bH.setAccessible(true);
        GameProfile og = (GameProfile) bH.get(entityPlayer);
        changeName(og.getName(), player);
    }
}
