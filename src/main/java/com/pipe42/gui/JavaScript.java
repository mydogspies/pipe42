package com.pipe42.gui;

import com.pipe42.prefs.InitializeUserPreferences;
import javafx.scene.web.WebEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A number of methods related to crafting our connection between JavaFX and Javascript
 * @author Peter Mankowski
 * @since 0.3.0
 */
public class JavaScript {

    private static final Logger log = LoggerFactory.getLogger(JavaScript.class);

    public void setInnerHtmlValues(WebEngine webengine, String node, String value) {

        webengine.executeScript("setInnerHtmlValues('" + node + "', '" + value +"')");
        log.trace("setInnerHtmlValues(): Executed Javascript: setInnerHtmlValues('" + node + "', '" + value + "')");

    }


}
