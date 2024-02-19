package view;

import controller.Controllable;

@FunctionalInterface
public interface CallOperations {
    String Operation(Controllable controller, String value1, String value2);
}
