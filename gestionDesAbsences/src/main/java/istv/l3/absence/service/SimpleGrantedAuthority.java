package istv.l3.absence.service;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class SimpleGrantedAuthority implements GrantedAuthority, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8912224523965184344L;
	private String role;

	public SimpleGrantedAuthority(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role;
	}

}
