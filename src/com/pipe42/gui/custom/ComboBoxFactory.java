package com.pipe42.gui.custom;

import com.pipe42.data.Xml;
import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;
import com.pipe42.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.List;

/**
 * Constructs comboboxes and populates them with data using a wrapper class. Takes a combobox
 * of type wrapper class as input and returns the wrapped and populated combobox object.
 * Note: The combobox must already be defined of the right wrapper type before passes as parameter.
 * Eg. private ComboBox<ComboOwner> ownerBox; but NOT instantiated!!
 */
public class ComboBoxFactory {

    /**
     * Takes a Combobox of type ComboOwner and returns a populated combobox object with owner ID wrapped to it
     * @param ownerBox combobox object of type ComboOwner
     * @return combobox object of type ComboOwner
     */
    public ComboBox<ComboOwner> getOwnerComboBox(ComboBox<ComboOwner> ownerBox) {

        List<Owner> ownerList = Main.factory.getIO().getAllOwners();

        ownerBox = new ComboBox<>();

        for (Owner owner: ownerList) {
            ownerBox.getItems().add(new ComboOwner(owner.getOwnerName(), owner.getOwnerId()));
        }

        ownerBox.setCellFactory(lv -> new ComboOwnerListCell());
        ownerBox.setButtonCell(new ComboOwnerListCell());

        return ownerBox;
    }

    /**
     * Takes a Combobox of type ComboApp and returns a populated combobox object with application ID wrapped to it
     * @param appBox combobox object of type ComboApp
     * @return combobox object of type ComboApp
     */
    public ComboBox<ComboApp> getAppComboBox(ComboBox<ComboApp> appBox) {

        List<Application> appList = Main.factory.getIO().getAllApps();
        appBox = new ComboBox<>();

        for (Application app: appList) {
            appBox.getItems().add(new ComboApp(app.getAppName(), app.getAppID()));
        }

        appBox.setCellFactory(lv -> new ComboAppListCell());
        appBox.setButtonCell(new ComboAppListCell());

        return appBox;
    }

    /**
     * Takes a Combobox of type ComboEngine and returns a populated combobox object with renderengine ID wrapped to it
     * @param engineBox combobox object of type ComboEngine
     * @return combobox object of type ComboEngine
     */
    public ComboBox<ComboEngine> getEngineComboBox(ComboBox<ComboEngine> engineBox) {

        List<Renderengine> engineList = Main.factory.getIO().getAllEngines();
        engineBox = new ComboBox<>();

        for (Renderengine eng: engineList) {
            engineBox.getItems().add(new ComboEngine(eng.getEngineName(), eng.getEngineID()));
        }

        engineBox.setCellFactory(lv -> new ComboEngineListCell());
        engineBox.setButtonCell(new ComboEngineListCell());

        return engineBox;
    }

    /**
     * Takes a Combobox of type ComboProject and returns a populated combobox object with project ID wrapped to it
     * @param projectBox combobox object of type ComboProject
     * @return combobox object of type ComboProject
     */
    public ComboBox<ComboProject> getProjectComboBox(ComboBox<ComboProject> projectBox) {

        List<Project> projectList = Main.factory.getIO().getAllProjects();

        projectBox = new ComboBox<>();

        for (Project project: projectList) {
            projectBox.getItems().add(new ComboProject(project.getProjectName(), project.getProjectID()));
        }

        projectBox.setCellFactory(lv -> new ComboProjectListCell());
        projectBox.setButtonCell(new ComboProjectListCell());

        return projectBox;
    }


    /**
     * Takes a Combobox of type String and returns a populated combobox object with folder templates
     * @param folderTemplate combobox object of type String
     * @return combobox object of type String
     */
    public ComboBox<String> getTemplateComboBox(ComboBox<String> folderTemplate) {

        List<String> templateList = Xml.getXmlTemplateNames();

        folderTemplate = new ComboBox<>();

        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(templateList);
        folderTemplate.getItems().addAll(options);

        return folderTemplate;
    }

}
