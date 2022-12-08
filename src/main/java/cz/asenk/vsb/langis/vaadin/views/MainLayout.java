package cz.asenk.vsb.langis.vaadin.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


/**
 * @author Alois Šenkyřík asenkyrik@monetplus.cz
 * @version 1.0
 * Created: 08.12.2022
 */

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("VIS Information System");
        logo.addClassNames("text-l", "m-m");

        Image image = new Image("/resources/ZLOPAPRIKA.png", "Zlopaprika Language school logo");

        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                image,
                logo
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Users", UserView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(listLink);
    }
}