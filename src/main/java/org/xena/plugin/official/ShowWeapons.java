package org.xena.plugin.official;

import org.xena.Indexer;
import org.xena.cs.*;
import org.xena.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;

public final class ShowWeapons extends Plugin {
    private ShowWeaponsWindow window; //= ShowWeaponsWindow.open(new ArrayList<>());
    @Override
    public void pulse(ClientState clientState, Me me, Indexer<GameEntity> entities) {
        ArrayList<String> args = new ArrayList<>();
        String string = "";
        for (var entity: entities) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                if (!player.isDead()) {
                    StringBuilder weapons = new StringBuilder();
                    for (var obj : player.getWeaponIds()) {
                        long weaponID = obj[0];
                        for (var weapon : Weapons.values())
                            if (weapon.getId() == weaponID) {
                                weapons.append(weapon.getWeaponName()).append(", ");
                            }
                    }
                    if (player.address() != me.address()) {
                        args.add(player.getId() + ": " + weapons.toString());
                    } else {
                        string = "Your weapons: " + weapons.toString();
                    }
                    //System.out.println((player.address() == me.address() ? "Your weapons" : player.getId()) + ": " + weapons.toString());
                }
            }
        }
        args.add(string);
        int weaponID = (int)me.getActiveWeapon().getWeaponID();
        for (var weapon: Weapons.values()) if (weapon.getId() == weaponID) {
            args.add("You're using " + weapon.getWeaponName());
            //System.out.println("You're using " + weapon.getWeaponName());
        }
        if (window == null) {
            window = ShowWeaponsWindow.open(args);
        } else window.repaint(args);
        sleep(100);
    }

    public void onEnable() {
        if(window == null) window = ShowWeaponsWindow.open(new ArrayList<>());
        window.setVisible(true);
    }

    public void onDisable() {
        window.setVisible(false);
    }
}
