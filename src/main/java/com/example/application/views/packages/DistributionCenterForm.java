package com.example.application.views.packages;

import com.example.application.views.entity.Center;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.LinkedList;

public class DistributionCenterForm extends FormLayout {
    ComboBox<Center> centersComboBox = new ComboBox<>("Distribution center");

    TextField name = new TextField("Name");

    Button save = new Button("Save");
    Button close = new Button("Close");

    public DistributionCenterForm(LinkedList<Center> centersList) {
        centersComboBox.setItems(centersList);
        centersComboBox.setItemLabelGenerator(Center::getName);

        add(centersComboBox, name, createButtonLayout());
    }

    private Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        close.addThemeVariants(ButtonVariant.LUMO_ERROR);

        save.addClickListener(click -> saveDistributionCenter());

        save.addClickShortcut(Key.ENTER);

        return new HorizontalLayout(save, close);
    }

    private void saveDistributionCenter() {
        if(centersComboBox.isEmpty() || name.isEmpty()) {
            Notification.show("Select distribution center and new name center");
        } else {
            Notification.show("Save distribution center name");
        }
    }
}
