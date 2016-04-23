package example;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_USER = "USER";

	private List<UserDetails> details = Arrays.<UserDetails> asList(new SimpleUserDetails("user", "user", ROLE_USER),
			new SimpleUserDetails("admin", "admin", ROLE_USER, ROLE_ADMIN));

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		for (UserDetails details : this.details) {
			if (details.getUsername().equalsIgnoreCase(username)) {
				return details;
			}
		}
		return null;
	}
}