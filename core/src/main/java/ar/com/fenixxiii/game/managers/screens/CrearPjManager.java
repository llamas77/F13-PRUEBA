package ar.com.fenixxiii.game.managers.screens;

import ar.com.fenixxiii.game.objects.UserAtributos;
import ar.com.fenixxiii.game.utils.Dialogs;
import ar.com.fenixxiii.game.utils.StrUtils;
import ar.com.fenixxiii.game.views.screens.MenuView;

public class CrearPjManager extends ViewManager {

    public CrearPjManager() {

    }

    @Override
    public void back() {
        setScreen(new MenuView());
    }

    public void solicTirarDados() {
        getClPack().writeThrowDices();
    }

    public UserAtributos getAttribActuales() {
        return getGD().getCurrentUser().getAtributos();
    }

    public void crearPj(String nombre, String contraseña, String rContraseña, String mail,
                        String rMail, int raza, int genero, int ciudad) {

        if (nombre.equals("")) {
            Dialogs.showOKDialog(bu("error"), "El nombre no puede estar vacío.");
            return;
        }

        if (contraseña.equals("")) {
            Dialogs.showOKDialog(bu("error"), "La contraseña no puede estar vacía.");
            return;
        }

        Character c = StrUtils.getInvalidChar(contraseña);
        if (c != null) {
            Dialogs.showOKDialog(bu("error"), "Contraseña inválida. No se permite el caractér '" + c + "'.");
            return;
        }

        if (mail.equals("")) {
            Dialogs.showOKDialog(bu("error"), "El mail no puede estar vacío.");
            return;
        }

        // TODO: Considerar chequear mail no válido (CheckMailString de VB6)

        if (!contraseña.equals(rContraseña)) {
            Dialogs.showOKDialog(bu("error"), "Las contraseñas no coinciden.");
            return;
        }

        if (!mail.equals(rMail)) {
            Dialogs.showOKDialog(bu("error"), "Los mails no coinciden.");
            return;
        }


        getClPack().writeLoginNewChar(nombre, contraseña, mail,
                raza, genero, ciudad);
    }

}
