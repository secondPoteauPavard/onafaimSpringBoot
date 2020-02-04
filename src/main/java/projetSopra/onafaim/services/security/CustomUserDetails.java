package projetSopra.onafaim.services.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import projetSopra.onafaim.model.Compte;


public class CustomUserDetails implements UserDetails {

	private Compte compte;

	public CustomUserDetails(Compte compte) {
		this.compte = compte;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorites = new HashSet<>();
		authorites.add(new SimpleGrantedAuthority(compte.getRole().toString()));
		return authorites;
	}

	@Override
	public String getPassword() {
		return compte.getPassword();
	}

	@Override
	public String getUsername() {
		return compte.getEmail();
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
		return compte.isEnable();
	}

}
