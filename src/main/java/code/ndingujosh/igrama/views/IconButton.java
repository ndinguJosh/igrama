package code.ndingujosh.igrama.views;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import javax.validation.constraints.NotNull;

public class IconButton extends Icon {
    /**
     * Creates an icon button with the default lumo primary color and a pointer cursor
     */
    public IconButton(@NotNull VaadinIcon icon) {
        super(icon);
        setColor("var(--lumo-primary-color)");
        getStyle().set("cursor", "pointer"); // so that it looks clickable
    }
}
