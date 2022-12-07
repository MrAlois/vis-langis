package cz.asenk.vsb.langis.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import cz.asenk.vsb.langis.jpa.model.User;

@Route(value = "")
@PageTitle("Contacts | Vaadin CRM")
public class UserView extends VerticalLayout {
    Grid<User> grid = new Grid<>(User.class);
    TextField filterText = new TextField();

    public UserView() {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        add(getToolbar(), grid);
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("Name", "Telephone", "Email");
        grid.addColumn(User::getName).setHeader("Name");
        grid.addColumn(User::getTelephone).setHeader("Telephone");
        grid.addColumn(User::getEmail).setHeader("Email");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addContactButton = new Button("Add contact");
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}