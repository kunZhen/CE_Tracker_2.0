package com.example.application.views.packages;

import com.example.application.views.entity.Center;
import com.example.application.views.entity.Package;
import com.example.application.views.structures.LinkList;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import javax.xml.stream.events.StartDocument;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PackageForm extends FormLayout {
    ComboBox<Center> startingPoint = new ComboBox<>("Starting point");
    ComboBox<Center> deliveryPoint = new ComboBox<>("Delivery point");

    Button send = new Button("Send");
    Button cancel = new Button("Cancel");
    LinkList hexCodeList = new LinkList();

    public PackageForm(LinkedList<Center> centerList) {
        addClassName("package-form");

        startingPoint.setItems(centerList);
        startingPoint.setItemLabelGenerator(Center::getName);

        deliveryPoint.setItems(centerList);
        deliveryPoint.setItemLabelGenerator(Center::getName);

        add(startingPoint, deliveryPoint, createButtonLayout());
    }

    private Component createButtonLayout() {
        send.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);

        send.addClickListener(event -> sendPackage());
        send.addClickShortcut(Key.ENTER);

        return new HorizontalLayout(send, cancel);
    }



    //url: https://es.stackoverflow.com/questions/526185/como-g%C3%A9nero-n%C3%BAmeros-aleatorios-en-formato-octal-y-hexadecimal#:~:text=Los%20n%C3%BAmeros%20en%20formato%20octal,luego%20los%20m%C3%A9todos%20est%C3%A1ticos%20Integer.
    private String generateHexCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(255);
        var hex = Integer.toHexString(randomNumber);

        //notify the hexCode created
        Notification.show("randomNumber: " + randomNumber);
        Notification.show("hex: " + hex);

        if (hexCodeList.inList(hex)) {
            return generateHexCode();
        } else{
            hexCodeList.add(hex);
            return hex;
        }
    }
    private void sendPackage() {
        if (startingPoint.isEmpty() || deliveryPoint.isEmpty()) {
            Notification.show("Select starting point and delivery point");
        } else{
            Package packageOnway;
            packageOnway = new Package(generateHexCode(), startingPoint.getValue(), deliveryPoint.getValue());
            //listView.getPackagesOnWayList().add(packageOnWay);
            //listView.updateDeliverGrid();

            Notification.show("Package on way! " + "HexCode: " + packageOnway.getHexCode() + " StartingPoint: " + packageOnway.getStartingPoint().getName()
                    + " DeliveryPoint: " + packageOnway.getDeliveryPoint().getName());
        }
    }
}
