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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Constructs comboboxes and populates them with data using a wrapper class. Takes a combobox
 * of type wrapper class as input and returns the wrapped and populated combobox object.
 * Note: The combobox must already be defined of the right wrapper type before passes as parameter.
 * Eg. private ComboBox<ComboOwner> ownerBox; but NOT instantiated!!
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboOwner
 * @see com.pipe42.gui.custom.ComboOwnerListCell
 */
public class ComboBoxFactory {

    private static final Logger log = LoggerFactory.getLogger(ComboBoxFactory.class);

    /**
     * Takes a Combobox of type ComboOwner and returns a populated combobox object with owner ID wrapped to it
     * @param ownerBox a combobox object
     * @return a combobox object
     */
    public ComboBox<ComboOwner> getOwnerComboBox(ComboBox<ComboOwner> ownerBox) {

        List<Owner> ownerList = Main.factory.getIO().getAllOwners();

        ownerBox = new ComboBox<>();

        for (Owner owner: ownerList) {
            ownerBox.getItems().add(new ComboOwner(owner.getOwnerName(), owner.getOwnerId()));
        }

        ownerBox.setCellFactory(lv -> new ComboOwnerListCell());
        ownerBox.setButtonCell(new ComboOwnerListCell());

        log.debug("getOwnerComboBox(): Returned a ComboBox object: + " + ownerBox);

        return ownerBox;
    }

    /**
     * Takes a Combobox of type ComboApp and returns a populated combobox object with application ID wrapped to it
     * @param appBox a combobox object
     * @return a combobox object
     */
    public ComboBox<ComboApp> getAppComboBox(ComboBox<ComboApp> appBox) {

        List<Application> appList = Main.factory.getIO().getAllApps();
        appBox = new ComboBox<>();

        for (Application app: appList) {
            appBox.getItems().add(new ComboApp(app.getAppName(), app.getAppID()));
        }

        appBox.setCellFactory(lv -> new ComboAppListCell());
        appBox.setButtonCell(new ComboAppListCell());

        log.debug("getAppComboBox(): Returned a ComboBox object: + " + appBox);

        return appBox;
    }

    /**
     * Takes a Combobox of type ComboEngine and returns a populated combobox object with renderengine ID wrapped to it
     * @param engineBox a combobox object
     * @return a combobox object
     */
    public ComboBox<ComboEngine> getEngineComboBox(ComboBox<ComboEngine> engineBox) {

        List<Renderengine> engineList = Main.factory.getIO().getAllEngines();
        engineBox = new ComboBox<>();

        for (Renderengine eng: engineList) {
            engineBox.getItems().add(new ComboEngine(eng.getEngineName(), eng.getEngineID()));
        }

        engineBox.setCellFactory(lv -> new ComboEngineListCell());
        engineBox.setButtonCell(new ComboEngineListCell());

        log.debug("getEngineComboBox(): Returned a ComboBox object: + " + engineBox);

        return engineBox;
    }

    /**
     * Takes a Combobox of type ComboProject and returns a populated combobox object with project ID wrapped to it
     * @param projectBox a combobox object
     * @return a combobox object
     */
    public ComboBox<ComboProject> getProjectComboBox(ComboBox<ComboProject> projectBox) {

        List<Project> projectList = Main.factory.getIO().getAllProjects();

        projectBox = new ComboBox<>();

        for (Project project: projectList) {
            projectBox.getItems().add(new ComboProject(project.getProjectName(), project.getProjectID()));
        }

        projectBox.setCellFactory(lv -> new ComboProjectListCell());
        projectBox.setButtonCell(new ComboProjectListCell());

        log.debug("getProjectComboBox(): Returned a ComboBox object: + " + projectBox);

        return projectBox;
    }


    /**
     * Takes a Combobox of type String and returns a populated combobox object with folder templates
     * @param folderTemplate a combobox object
     * @return a combobox object
     */
    public ComboBox<String> getTemplateComboBox(ComboBox<String> folderTemplate) {

        List<String> templateList = Xml.getXmlTemplateNames();

        folderTemplate = new ComboBox<>();

        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(templateList);
        folderTemplate.getItems().addAll(options);

        log.debug("getTemplateComboBox(): Returned a ComboBox object: + " + folderTemplate);

        return folderTemplate;
    }

}
