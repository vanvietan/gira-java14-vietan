package cybersoft.javabackend.girajava14vietan.common.exception;

import javax.persistence.EntityNotFoundException;

public class GiraEntityNotFoundException extends EntityNotFoundException{
	
	public GiraEntityNotFoundException(String msg) {
		super(msg);
	}
}
