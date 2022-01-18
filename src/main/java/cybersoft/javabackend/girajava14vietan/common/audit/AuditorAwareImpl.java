package cybersoft.javabackend.girajava14vietan.common.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();
		
		if(auth == null) {
			return Optional.ofNullable("");
		}
		UserDetails user = (UserDetails)auth.getPrincipal();
		
		return Optional.ofNullable(user.getUsername());
	}

}
