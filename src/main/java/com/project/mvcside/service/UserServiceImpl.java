package com.project.mvcside.service;

import com.project.mvcside.model.wsdto.RoleWsDto;
import com.project.mvcside.model.wsdto.TaskWsDto;
import com.project.mvcside.model.wsdto.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
    public UserWsDto findByUsername(String username) {
        return constructUserWsDto(username, true);
    }

    @Override
    public void addTaskToCustomer(String username, TaskWsDto taskWsDto) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserWsDto user = constructUserWsDto(username, true);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username or password");
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),true, true, true, true,mapRolesToAuthorities(user.getRoleWsDtos()));

    }

    private UserWsDto constructUserWsDto(String username, boolean isAuth) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(restUrl.concat("/username"))
                .queryParam("username", username)
                .queryParam("isAuth", isAuth)
                .build();
        UserWsDto user = restTemplate
                .exchange(builder.toUriString(), HttpMethod.GET, entity, UserWsDto.class)
                .getBody();
        return user;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleWsDto> roles){
        return roles.stream()
                .map(roleWsDto -> new SimpleGrantedAuthority(roleWsDto.getName()))
                .collect(Collectors.toList());
    }

}
