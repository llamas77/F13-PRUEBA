package ar.com.fenixxiii.game.general;

import ar.com.fenixxiii.game.Main;

/**
 * Clase para el control de la carga de recursos del juego (en Web)
 *
 * cargado: indica si se cargaron los recursos
 */
public class WebLoader implements Loader {
    private boolean cargado;

    public WebLoader() {
    }

    @Override
    public void load() {
        // Carga en el mismo thread
        Main.getInstance().getAssets().loadRemaining();
        cargado = true;
    }

    @Override
    public boolean isLoading() {
        /* como se realiza en un solo hilo, nunca se va a chequear si se esta cargando al mismo tiempo en que
           realmente se estan cargando los recursos. Por lo tanto devuelvo Falso. */
        return false;
    }

    @Override
    public boolean isLoaded() {
        return cargado;
    }
}