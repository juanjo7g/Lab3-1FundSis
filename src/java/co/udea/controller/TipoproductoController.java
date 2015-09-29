package co.udea.controller;

import co.udea.controller.util.MobilePageController;
import co.udea.modelo.Tipoproducto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoproductoController")
@ViewScoped
public class TipoproductoController extends AbstractController<Tipoproducto> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoproductoController() {
        // Inform the Abstract parent controller of the concrete Tipoproducto Entity
        super(Tipoproducto.class);
    }

    /**
     * Sets the "items" attribute with a collection of Producto entities that
     * are retrieved from Tipoproducto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Producto page
     */
    public String navigateProductoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Producto_items", this.getSelected().getProductoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ui/producto/index";
    }

}
