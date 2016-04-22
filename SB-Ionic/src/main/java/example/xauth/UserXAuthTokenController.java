package example.xauth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import example.xauth.pojo.AuthenticationRequest;

/**
 * This controller generates the token that must be present in subsequent REST
 * invocations.
 */
@RestController
@Api("user")
public class UserXAuthTokenController {
	private final TokenUtils tokenUtils = new TokenUtils();
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;

	@Autowired
	public UserXAuthTokenController(AuthenticationManager am, UserDetailsService userDetailsService) {
		this.authenticationManager = am;
		this.userDetailsService = userDetailsService;
	}

	@RequestMapping(value = "/authenticate", method = { RequestMethod.POST })
	@ApiOperation(value = "authenticate")
	public UserTransfer authorize(@RequestBody AuthenticationRequest authenticationRequest) {
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails details = this.userDetailsService.loadUserByUsername(username);

		Map<String, Boolean> roles = new HashMap<String, Boolean>();
		for (GrantedAuthority authority : details.getAuthorities())
			roles.put(authority.toString(), Boolean.TRUE);

		return new UserTransfer(details.getUsername(), roles, tokenUtils.createToken(details));
	}
}
