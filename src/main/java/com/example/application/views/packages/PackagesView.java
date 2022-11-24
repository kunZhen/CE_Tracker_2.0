package com.example.application.views.packages;

import com.example.application.views.MainLayout;
import com.example.application.views.entity.Package;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.hibernate.mapping.Value;

@PageTitle("Packages Tracker")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class PackagesView extends VerticalLayout {
    Grid<Package> packageGrid = new Grid<>(Package.class);
    TextField filterText = new TextField();


    public PackagesView() {
        addClassName("list-view");
        setSizeFull();

        configurePackageGrid();

        add(getToolbar(), packageGrid);

    }

    private Component getToolbar() {
        filterText.setPlaceholder("Filter by Hex Code...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addPackageButton = new Button("Add package");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addPackageButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configurePackageGrid() {
        packageGrid.addClassName("package-grid");
        packageGrid.setSizeFull();
        packageGrid.setColumns("hexCode", "startingPoint", "deliveryPoint", "waitingTime");
        packageGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

}

