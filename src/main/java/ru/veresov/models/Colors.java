package ru.veresov.models;

import java.awt.*;

public enum Colors {
    RED(Color.RED),
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN);

    Color color;

    Colors(Color color) {
        this.color = color;
    }
}
