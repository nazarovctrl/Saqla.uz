
package com.example.thymleaf.config.security;

import com.example.thymleaf.entity.ProfileEntity;
import com.example.thymleaf.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // alish
        Optional<ProfileEntity> optional = profileRepository.findByEmail(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("Bad Cretensional");
        }

        ProfileEntity profile = optional.get();
//        return new CustomUserDetails(profile);
        return new CustomUserDetails(profile.getId(),profile.getEmail(), profile.getPassword(), profile.getRole());
    }
}
