package cz.asenk.vsb.langis.vaadin.views;

import javax.annotation.security.PermitAll;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import cz.asenk.vsb.langis.jpa.domain.User;
import cz.asenk.vsb.langis.service.UserService;
import cz.asenk.vsb.langis.vaadin.component.UserForm;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Users | VIS IS")
@PermitAll
public class UserView extends VerticalLayout {
    Grid<User> grid = new Grid<>(User.class);
    TextField filterText = new TextField();

    UserForm userForm;

    final UserService userService;

    public UserView(UserService userService) {
        this.userService = userService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("id" ,"name", "password", "email", "telephone");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editContact(event.getValue()));
    }

    private void configureForm() {
        userForm = new UserForm();
        userForm.setWidth("25em");
        userForm.addListener(UserForm.SaveEvent.class, this::saveContact);
        userForm.addListener(UserForm.DeleteEvent.class, this::deleteContact);
        userForm.addListener(UserForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveContact(UserForm.SaveEvent event) {
        userService.saveUser(event.getSource().getUser());
        updateList();
        closeEditor();
    }

    private void deleteContact(UserForm.DeleteEvent event) {
        userService.deleteUser(event.getSource().getUser().getId());

        updateList();
        closeEditor();
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addUserButton = new Button("Add user");
        addUserButton.addClickListener(click -> addUser());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addUserButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    public void editContact(User user) {
        if (user == null) {
            closeEditor();
        } else {
            userForm.setUser(user);
            userForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        userForm.setUser(null);
        userForm.setVisible(false);
        removeClassName("editing");
    }

    private void addUser() {
        grid.asSingleSelect().clear();
        editContact(new User());
    }

    private void updateList() {
        grid.setItems(userService.findAllUsersFilter(filterText.getValue()));
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, userForm);
        content.setFlexGrow(2, grid);

        content.setFlexGrow(1, userForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
}