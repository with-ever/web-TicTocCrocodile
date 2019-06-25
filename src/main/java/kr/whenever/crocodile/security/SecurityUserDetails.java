package kr.whenever.crocodile.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUserDetails implements UserDetails {
	//
	private String username;
	private String password;
	
	private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private Collection<GrantedAuthority> authorities;
	
    public SecurityUserDetails() {
    	//
    }
    
    public SecurityUserDetails(String username, String password, Collection<GrantedAuthority> authorities) {
    	//
    	this.username = username;
    	this.password = password;
    	this.authorities = authorities;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//
		return this.authorities;
	}

	@Override
	public String getPassword() {
		//
		return this.password;
	}

	@Override
	public String getUsername() {
		//
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		//
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		//
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		//
		return this.enabled;
	}

}
