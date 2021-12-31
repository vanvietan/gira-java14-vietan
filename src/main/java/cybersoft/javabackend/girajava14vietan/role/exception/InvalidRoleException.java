package cybersoft.javabackend.girajava14vietan.role.exception;

public class InvalidRoleException extends RuntimeException{
	public InvalidRoleException() {
		super();
	}
	public InvalidRoleException(String message) {
		super(message);
	}
	public InvalidRoleException(String message , Throwable throwable) {
		super(message , throwable);
	}
}
