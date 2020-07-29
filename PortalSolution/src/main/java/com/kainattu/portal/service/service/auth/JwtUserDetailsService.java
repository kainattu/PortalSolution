package com.kainattu.portal.service.service.auth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kainattu.portal.service.dto.auth.UserDTO;
import com.kainattu.portal.service.model.auth.DAORole;
import com.kainattu.portal.service.model.auth.DAOUser;
import com.kainattu.portal.service.repo.auth.RoleRepo;
import com.kainattu.portal.service.repo.auth.UserDao;

/**
 * @author Palanivel Muthu Gounder
 *
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getGrantedAuthorities(user.getRoles()));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(final Set<DAORole> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        for (final DAORole privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege.getRole()));
        }
        return authorities;
    }


	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setMobileNo(user.getMobileNo());
		Set<DAORole> roleList = new HashSet<DAORole>();
		if(user.getRoles()!=null) {
			for(String role: user.getRoles()) {
				DAORole daoRole = roleRepo.findByRole(role);
				//DAORole daoRole = new DAORole();
				//daoRole.setRole(role);
				roleList.add(daoRole);
			}
		}
		newUser.setRoles(roleList);
		return userDao.save(newUser);
	}

	public List<DAOUser> getAllUser() {
		return (List<DAOUser>) userDao.findAll();
	}
	
	public DAOUser getUser(String username) {
		return userDao.findByUsername(username);
	}

}