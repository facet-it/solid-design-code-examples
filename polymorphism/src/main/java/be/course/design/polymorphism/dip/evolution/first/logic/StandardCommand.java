package be.course.design.polymorphism.dip.evolution.first.logic;

import java.util.Arrays;

enum StandardCommand {
    STOP("stop");

    private String writeName;

    StandardCommand(String writeName) {
        this.writeName = writeName;
    }

    public String getWriteName() {
        return this.writeName;
    }

    public boolean equals(String input) {
        return this.getWriteName().equals(input.toLowerCase());
    }

    public static boolean isStopCommand(String input) {
        return StandardCommand.STOP.getWriteName().equals(input.toLowerCase());
    }

    public static String toCommand(String inputCommand) {
        return Arrays.stream(StandardCommand.values())
            .map(StandardCommand::getWriteName)
            .filter(command -> command.equals(inputCommand.toLowerCase()))
            .findFirst()
            .orElse(inputCommand);
    }
}
