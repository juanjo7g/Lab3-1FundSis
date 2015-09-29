package co.udea.controller;

import co.udea.controller.util.MobilePageController;
import co.udea.modelo.Producto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "productoController")
@ViewScoped
public class ProductoController extends AbstractController<Producto> {

    @Inject
    private TipoproductoController tipoproductoIdController;
    @Inject
    private MobilePageController mobilePageController;

    public ProductoController() {
        // Inform the Abstract parent controller of the concrete Producto Entity
        super(Producto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tipoproductoIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Tipoproducto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoproductoId(ActionEvent event) {
        if (this.getSelected() != null && tipoproductoIdController.getSelected() == null) {
            tipoproductoIdController.setSelected(this.getSelected().getTipoproductoId());
        }
    }
}
