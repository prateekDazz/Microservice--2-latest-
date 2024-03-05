package net.prateekdazz.employeeservice.exception;

public class UserAlreadyExistsException  extends RuntimeException{

    private String resourceName;
    private Long fieldValue;

    public UserAlreadyExistsException(String resourceName, Long fieldValue) {
        super(String.format("%s  with  id %s  already exists", resourceName, fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
    }
}
