package de.awtools.schoolplanner.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
    
    
    public static class MyUserPrincipal implements UserDetails {
        private User user;

        public MyUserPrincipal(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getPassword() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getUsername() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isAccountNonExpired() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isEnabled() {
            // TODO Auto-generated method stub
            return false;
        }
    }    
}

