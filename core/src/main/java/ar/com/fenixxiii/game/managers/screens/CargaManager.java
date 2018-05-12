package ar.com.fenixxiii.game.managers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import ar.com.fenixxiii.game.Main;
import ar.com.fenixxiii.game.general.GnLoader;
import ar.com.fenixxiii.game.general.Loader;
import ar.com.fenixxiii.game.general.WebLoader;
import ar.com.fenixxiii.game.views.screens.MenuView;


public class CargaManager extends ViewManager {

    private Loader loader;
    private long tiempoInicio;
    private boolean solicitaSalir;

    public CargaManager() {
        // Crea el Loader
        loader = new GnLoader();

        tiempoInicio = TimeUtils.millis();
    }

    public void salir() {
        solicitaSalir = true;
    }

    public void update() {
        float value;
        value = Main.getInstance().getAssets().loadNextAsset();

        if (value == 1 && !loader.isLoading() && !loader.isLoaded())
            loader.load();

        if (loader.isLoaded() && (TimeUtils.millis() - tiempoInicio > 6000 || solicitaSalir)) {
            setScreen(new MenuView());
        }
    }
}
