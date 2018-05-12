package ar.com.fenixxiii.game.views.windows;

import ar.com.fenixxiii.game.actors.Window;

public class ComerciarWindow extends Window {
    public ComerciarWindow() {
        super("Comerciar");
    }

    @Override
    protected void close() {
        super.close();

        getClPack().writeCommerceEnd();
    }
}
