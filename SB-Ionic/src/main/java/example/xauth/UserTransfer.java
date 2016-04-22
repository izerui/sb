package example.xauth;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserTransfer {
	private final String name;
	private final Map<String, Boolean> roles;
	private final String token;

	public UserTransfer(String userName, Map<String, Boolean> roles, String token) {
		Map<String, Boolean> mapOfRoles = new ConcurrentHashMap<String, Boolean>();
		for (String k : roles.keySet()) {
			mapOfRoles.put(k, roles.get(k));
		}
		this.roles = mapOfRoles;
		this.token = token;
		this.name = userName;
	}

	public String getName() {
		return this.name;
	}

	public Map<String, Boolean> getRoles() {
		return this.roles;
	}

	public String getToken() {
		return this.token;
	}
}