package org.xena.plugin.official;

import org.xena.Indexer;
import org.xena.cs.ClientState;
import org.xena.cs.GameEntity;
import org.xena.cs.Me;
import org.xena.plugin.Plugin;

public final class ShowWeapons extends Plugin {
    @Override
    public void pulse(ClientState clientState, Me me, Indexer<GameEntity> entities) {
        System.out.println("it works!");
        sleep(10);
    }
}
