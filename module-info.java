/**
 *
 */
module Chen.Yutian.Intellij.Java12 {
        requires javafx.graphics;
        requires javafx.controls;
        requires javafx.media;
        requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires junit;
    opens Calculations to javafx.base;
        exports Menu;
        }