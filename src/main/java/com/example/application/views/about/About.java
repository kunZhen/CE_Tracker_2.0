package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.example.application.views.entity.Center;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Distribution centers")
@Route(value = "centers", layout = MainLayout.class)
public class About extends VerticalLayout {
    Button editCentersButton = new Button("Edit Centers");
    Grid<Center> centersToEditGrid = new Grid<>();


    public About() {

        editCentersButton.addClickListener(click -> editCenters());

        add(editCentersButton, centersToEditGrid);
    }

    private void editCenters() {

    }

    private void configureCentersToEditGrid() {
        centersToEditGrid.setSizeFull();
        centersToEditGrid.setColumns("name");
    }

}
