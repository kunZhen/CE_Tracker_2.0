package com.example.application.views.packages;

import com.example.application.views.MainLayout;
import com.example.application.views.entity.Center;
import com.example.application.views.entity.Package;
import com.example.application.views.repository.CentersRepository;
import com.example.application.views.structures.Graph;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.LinkedList;

@PageTitle("Packages Tracker")
@Route(value = "packages", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class PackagesView extends VerticalLayout {
    Grid<Package> packageGrid = new Grid<>(Package.class);
    TextField filterText = new TextField();
    PackageForm packageForm;
    Graph graph = new Graph();

    Graph map = graph.randomGraph();
    RadioButtonGroup<String> deliveryRoutes = new RadioButtonGroup<>();


    public PackagesView() {

        addClassName("list-view");
        setSizeFull();

        map.matchCenters();

        configurePackageGrid();
        configurePackageForm(getCenters());
        configureDeliveryRoutes();

        add(getToolbar(), getContent(), deliveryRoutes);

        packageForm.setVisible(false);
        //updateList();
    }

    private void configureDeliveryRoutes() {
        deliveryRoutes.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        deliveryRoutes.setLabel("Delivery routes - Costs");
        deliveryRoutes.setItems("Puerto Rico $60", "Guyana Francesa $20", "Monzambique $150");
    }

    private LinkedList<Center> getCenters() {
        LinkedList<Center> centersList = new LinkedList<>();

        for(int i = 0; i < (map.getCenters().length); i++){
            if (map.getCenters()[i].isDistributes()) {
                centersList.add(map.getCenters()[i]);
            }
        }
        return centersList;
    }

    /*private void updateList() {
        packageGrid.setItems(service.finAllPackages(filterText.getValue()));
    }*/

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(packageGrid, packageForm);
        content.setFlexGrow(2, packageGrid);
        content.setFlexGrow(1, packageForm);
        content.addClassName("content");
        content.setSizeFull();

        return content;
    }

    private void configurePackageForm(LinkedList<Center> centerList) {
        packageForm = new PackageForm(centerList);
        packageForm.setWidth("25em");
    }

    private Component getToolbar() {
        filterText.setPlaceholder("Filter by Hex Code...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        //filterText.addValueChangeListener(e -> updateList());

        Button addPackageButton = new Button("Add package");
        addPackageButton.addClickListener(click -> addPackage());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addPackageButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addPackage() {
        if (packageForm.isVisible()) {
            packageForm.setVisible(false);
        } else{
            packageForm.setVisible(true);
        }
    }

    private void configurePackageGrid() {
        packageGrid.addClassName("package-grid");
        packageGrid.setSizeFull();
        packageGrid.setColumns("hexCode", "startingPoint", "deliveryPoint", "waitingTime");
        packageGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

}

