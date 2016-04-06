package com.GameEngine.logic.action.command;

/**
 * Исключение возникающее если заданный параметр не был найден.
 */
public class IncorrectlySetParameter extends RuntimeException {
    private String nameParameter;
    private String parameter;

    public IncorrectlySetParameter(String nameParameter, String parameter) {
        this.nameParameter = nameParameter;
        this.parameter = parameter;
    }

    public IncorrectlySetParameter(String message, String nameParameter, String parameter) {
        super(message);
        this.nameParameter = nameParameter;
        this.parameter = parameter;
    }

    public IncorrectlySetParameter(String message, Throwable cause, String nameParameter, String parameter) {
        super(message, cause);
        this.nameParameter = nameParameter;
        this.parameter = parameter;
    }

    public IncorrectlySetParameter(Throwable cause, String nameParameter, String parameter) {
        super(cause);
        this.nameParameter = nameParameter;
        this.parameter = parameter;
    }

    public IncorrectlySetParameter(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String nameParameter, String parameter) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.nameParameter = nameParameter;
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    @Override
    public String getMessage() {
        return "Исключение было вызвано при задавания параметра:\n" +
                "NameParameter = "+nameParameter+"\n" +
                "Parameter = "+parameter+"\n" +
                "Подробнее = ("+super.getMessage()+")\n";
    }
}
