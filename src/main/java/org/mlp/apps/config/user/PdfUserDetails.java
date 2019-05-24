package org.mlp.apps.config.user;

import org.mlp.apps.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;

public class PdfUserDetails implements UserDetails {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 5618342584085761606L;
	
	private User user;
	
    public PdfUserDetails(User user) {
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream().map(authority -> new SimpleGrantedAuthority(authority.getLibelle().toString())).collect(Collectors.toList());
    }
    public Long getId() {
    	return Long.parseLong(user.getId().toString());
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public String getUsername() {
        return user.getEmail();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    public User getUserDetails() {
        return user;
    }
}