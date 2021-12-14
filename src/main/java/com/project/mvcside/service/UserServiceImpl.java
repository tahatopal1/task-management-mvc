package com.project.mvcside.service;

import com.project.mvcside.model.RoleWsDto;
import com.project.mvcside.model.TaskWsDto;
import com.project.mvcside.model.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${users.rest.url}")
    private String restUrl;

    @Override
    public List<UserWsDto> findAll() {
        return restTemplate
                .exchange(restUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserWsDto>>() {})
                .getBody();
    }

    @Override
    public UserWsDto find() {
        return null;
    }

    @Override
    public void addTaskToCustomer(String username, TaskWsDto taskWsDto) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        UserWsDto user = restTemplate
                .getForObject(restUrl.concat("/username").concat("/{username}"),
                              UserWsDto.class,
                              params);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username or password");
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),true, true, true, true,mapRolesToAuthorities(user.getRoleWsDtos()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleWsDto> roles){
        return roles.stream()
                .map(roleWsDto -> new SimpleGrantedAuthority(roleWsDto.getName()))
                .collect(Collectors.toList());
    }

}
