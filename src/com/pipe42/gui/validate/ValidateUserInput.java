package com.pipe42.gui.validate;

import com.pipe42.data.pojos.Project;
import com.pipe42.main.Main;
import com.pipe42.prefs.UserPreferences;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is the custom validator building upon ControlsFX underlying code
 * Each method is specific to a certain controller and passing the appropriate
 * field name will trigger custom validity checks.
 */
public class ValidateUserInput {

    // TODO must add methods for all the comboboxes in general.

    // Project_newProject //

    /**
     * Validates the "Project name" TextField in the Project_newProjectC.java controller
     *
     * @param bool  takes the predefined boolean of type AtomicBoolean for the specific field
     * @param field the specific field of type TextField as defined by fxml in the controller
     */
    public void validateNewProjectName(AtomicBoolean bool, TextField field) {

        ValidationSupport val = new ValidationSupport();
        val.setErrorDecorationEnabled(false);

        Validator<String> validator = new Validator<String>() {


            @Override
            public ValidationResult apply(Control control, String s) {

                boolean condition = false;

                if (!field.getText().isEmpty()) {

                    Project res = Main.factory.getIO().getProjectByName(field.getText());

                    if (res == null) {
                        condition = true;
                        bool.set(true);
                    } else {
                        condition = false;
                        bool.set(false);
                    }

                } else {
                    condition = false;
                    bool.set(false);
                }

                return ValidationResult.fromMessageIf(control, "Field empty or name exists already", Severity.ERROR, condition);
            }
        };

        val.registerValidator(field, true, validator);
    }

    /**
     * Validates the "Project prefix" TextField in the Project_newProjectC.java controller
     *
     * @param bool  takes the predefined boolean of type AtomicBoolean for the specific field
     * @param field the specific field of type TextField as defined by fxml in the controller
     */
    public void validateNewProjectPrefix(AtomicBoolean bool, TextField field) {

        ValidationSupport val = new ValidationSupport();
        val.setErrorDecorationEnabled(false);

        Validator<String> validator = new Validator<String>() {


            @Override
            public ValidationResult apply(Control control, String s) {

                boolean condition = false;

                int projectInt = UserPreferences.userSettings.getInt("projectPrefixLength", 6);
                if (!field.getText().isEmpty() && field.getText().length() < projectInt) {

                    String res = Main.factory.getIO().getPrefixByName(field.getText());

                    if (res == null) {
                        condition = true;
                        bool.set(true);
                    } else {
                        condition = false;
                        bool.set(false);
                    }

                } else {
                    condition = false;
                    bool.set(false);
                }

                return ValidationResult.fromMessageIf(control, "Field empty or name exists already", Severity.ERROR, condition);
            }
        };

        val.registerValidator(field, true, validator);

    }

}
