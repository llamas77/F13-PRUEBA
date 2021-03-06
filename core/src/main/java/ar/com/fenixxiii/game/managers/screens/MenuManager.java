package ar.com.fenixxiii.game.managers.screens;

import ar.com.fenixxiii.game.utils.Dialogs;
import ar.com.fenixxiii.game.views.screens.CrearPjView;

public class MenuManager extends ViewManager {

    public MenuManager() {

    }

    public void conectar(String nombre, String contraseña) {
        if (nombre.equals(""))
            Dialogs.showOKDialog("Error", "El nombre no puede estar vacío.");
        else if (contraseña.equals(""))
            Dialogs.showOKDialog("Error", "La contraseña no puede estar vacía");
        else {
            if (getConnection().connect())
                getClPack().writeLoginExistingChar(nombre, contraseña);
        }
    }

    public void crearPj() {
        if (getConnection().connect()) {
            setScreen(new CrearPjView());
            getClPack().writeThrowDices();
        }
    }
}
