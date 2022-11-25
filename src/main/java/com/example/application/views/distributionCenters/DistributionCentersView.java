package com.example.application.views.distributionCenters;

import com.example.application.views.MainLayout;
import com.example.application.views.entity.Center;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


/**
 * It's a view that display the distribution centers
 */
@PageTitle("Distribution centers")
@Route(value = "distributionCenters", layout = MainLayout.class)
public class DistributionCentersView extends VerticalLayout {
    Grid<Center> centerDistributionGrid = new Grid<>();

    public DistributionCentersView() {
        add(new H2("Distribution centers"));
        add(centerDistributionGrid);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }



}
