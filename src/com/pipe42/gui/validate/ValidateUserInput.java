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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is the custom validator building upon ControlsFX underlying code
 * Each method is specific to a certain controller and passing the appropriate
 * field name will trigger custom validity checks.
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class ValidateUserInput {

    private static final Logger log = LoggerFactory.getLogger(ValidateUserInput.class);


    // NEW PROJECT //
    //

    /**
     * Validates the "Project name" TextField in the Project_newProjectC.java controller and sets
     * a flag for the condition.
     * @param bool  the condition flag that is specific to each field
     * @param field the TexTField object
     */
    public void validateNewProjectName(AtomicBoolean bool, TextField field) {

        log.debug("validateNewProjectName(): Entered validation method");

        ValidationSupport val = new ValidationSupport();
        val.setErrorDecorationEnabled(false);

        Validator<String> validator = new Validator<String>() {

            @Override
            public ValidationResult apply(Control control, String s) {

                boolean condition;

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
     * Validates the "Project prefix" TextField in the Project_newProjectC.java controller and sets
     * a flag for the condition.
     * @param bool  the condition flag that is specific to each field
     * @param field the TexTField object
     */
    public void validateNewProjectPrefix(AtomicBoolean bool, TextField field) {

        log.debug("validateNewProjectPrefix(): Entered validation method");

        ValidationSupport val = new ValidationSupport();
        val.setErrorDecorationEnabled(false);

        Validator<String> validator = new Validator<String>() {

            @Override
            public ValidationResult apply(Control control, String s) {

                boolean condition;

                int projectInt = UserPreferences.userSettings.getInt("projectPrefixLength", 6);
                if (!field.getText().isEmpty() && field.getText().length() < projectInt) {

                    Project res = Main.factory.getIO().getProjectByPrefix(field.getText());

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


    // EDIT PROJECT //
    //

    /**
     * Validates the "Project name" TextField in the Project_editProjectC.java controller and sets
     * a flag for the condition.
     * @param bool  the condition flag that is specific to each field
     * @param field the TexTField object
     * @param id the project id
     */
    public void validateEditProjectName(AtomicBoolean bool, TextField field, String id) {

        log.debug("validateNewProjectName(): Entered validation method");

        ValidationSupport val = new ValidationSupport();
        val.setErrorDecorationEnabled(false);

        Validator<String> validator = new Validator<String>() {

            @Override
            public ValidationResult apply(Control control, String s) {

                boolean condition ;

                if (!field.getText().isEmpty()) {

                    Project byName = Main.factory.getIO().getProjectByName(field.getText());

                    if (byName != null && !byName.getProjectID().equals(id)) {
                        condition = false;
                        bool.set(false);
                    } else {
                        condition = true;
                        bool.set(true);
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
     * Validates the "Project prefix" TextField in the Project_editProjectC.java controller and sets
     * a flag for the condition.
     * @param bool  the condition flag that is specific to each field
     * @param field the TexTField object
     * @param id the project id
     */
    public void validateEditProjectPrefix(AtomicBoolean bool, TextField field, String id) {

        log.debug("validateNewProjectPrefix(): Entered validation method");

        ValidationSupport val = new ValidationSupport();
        val.setErrorDecorationEnabled(false);

        Validator<String> validator = new Validator<String>() {

            @Override
            public ValidationResult apply(Control control, String s) {

                boolean condition = false;

                int projectInt = UserPreferences.userSettings.getInt("projectPrefixLength", 6);
                if (!field.getText().isEmpty() && field.getText().length() < projectInt) {

                    Project byPrefix = Main.factory.getIO().getProjectByPrefix(field.getText());

                    if (byPrefix != null && !byPrefix.getProjectID().equals(id)) {
                        condition = false;
                        bool.set(false);
                    } else {
                        condition = true;
                        bool.set(true);
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
