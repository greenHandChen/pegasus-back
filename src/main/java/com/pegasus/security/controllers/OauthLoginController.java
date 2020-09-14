package com.pegasus.security.controllers;

import com.pegasus.security.dto.AuthenticationResult;
import com.pegasus.security.service.Oauth2LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by enHui.Chen on 2020/9/14.
 */
@RestController
@RequestMapping("/v1/oauth/token")
public class OauthLoginController {
    @Autowired
    private Oauth2LoginService oauthLoginService;

    @PostMapping("/no-password")
    public ResponseEntity<AuthenticationResult> cuxAuth(HttpServletRequest request) {
        return ResponseEntity.ok(oauthLoginService.getOauth2AccessToken(request));
    }
}
