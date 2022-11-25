package com.example.application.views.packages;

import com.example.application.views.entity.Center;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import javax.xml.stream.events.StartDocument;
import java.util.LinkedList;
import java.util.List;

public class PackageForm extends FormLayout {
    LinkedList<Center> centersList = new LinkedList<>();
    ComboBox<Center> startingPoint = new ComboBox<>("Starting point");
    ComboBox<Center> deliveryPoint = new ComboBox<>("Delivery point");

    Button send = new Button("Send");
    Button cancel = new Button("Cancel");

    public PackageForm() {
        addClassName("package-form");

        startingPoint.setItems(centersList);
        startingPoint.setItemLabelGenerator(Center::getName);

        deliveryPoint.setItems(centersList);
        deliveryPoint.setItemLabelGenerator(Center::getName);

        add(startingPoint, deliveryPoint, createButtonLayout());
    }

    private Component createButtonLayout() {
        send.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);

        send.addClickShortcut(Key.ENTER);

        return new HorizontalLayout(send, cancel);
    }

    public LinkedList<Center> getCentersList() {
        return centersList;
    }

    public void setCentersList(LinkedList<Center> centersList) {
        this.centersList = centersList;
    }
}
