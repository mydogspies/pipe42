package com.pipe42.gui;

import com.pipe42.data.JsonDataIO;
import com.pipe42.data.Project;
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


    // Project_newProject //

    /**
     * Validates the TextFields in the Project_newProjectC.java controller
     * @param bool takes the predefined boolean of type AtomicBoolean for the specific field
     * @param field the specific field of type TextField as defined by fxml in the controller
     */
    public void validateNewProjectFields(AtomicBoolean bool, TextField field) {

        ValidationSupport val = new ValidationSupport();

        Validator<String> validator = new Validator<String>() {

            @Override
            public ValidationResult apply(Control control, String s) {

                boolean condition;

                // check if the field is empty
                if (s.isEmpty()) {
                    condition = false;
                    bool.set(false);
                } else {

                    JsonDataIO io = new JsonDataIO();
                    Project result = io.getProjectByName(field.getText());
                    System.out.println(result);
                    condition = true;
                    bool.set(true);
                }

                System.out.println(condition);

                return ValidationResult.fromMessageIf(control, "This field can not be empty", Severity.ERROR, condition);
            }
        };

        val.registerValidator(field, true, validator);
    }

}
