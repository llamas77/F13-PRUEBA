package ar.com.fenixxiii.game.managers.screens;

import com.badlogic.gdx.Screen;
import ar.com.fenixxiii.game.Main;
import ar.com.fenixxiii.game.connection.ClientPackages;
import ar.com.fenixxiii.game.connection.Connection;
import ar.com.fenixxiii.game.connection.ServerPackages;
import ar.com.fenixxiii.game.containers.GameData;
import ar.com.fenixxiii.game.views.screens.View;

public abstract class ViewManager {

    public ViewManager() {

    }

    /**
     * Realiza actualizaciones constantemente
     *
     * No debe ser llamado.. solo hacer Override.. ya es llamado desde la clase abstracta {@link View}
     */
    public void update() {

    }

    public void playMusic(int num) {
        Main.getInstance().getAssets().getAudio().playMusic(num);
    }

    public void exitGame() {
        Main.getInstance().salir();
    }

    public void restartGame() {
        Main.getInstance().reiniciar();
    }

    public void back() {

    }

    protected void setScreen(Screen scr) { Main.getInstance().setScreen(scr); }
    protected ClientPackages getClPack() { return Main.getInstance().getConnection().getClPack(); }
    protected ServerPackages getSvPack() { return Main.getInstance().getConnection().getSvPack(); }
    protected Connection getConnection() { return Main.getInstance().getConnection(); }
    protected GameData getGD() { return Main.getInstance().getGameData(); }
    protected String bu(String key) { return Main.getInstance().getBundle().get(key); }
}
