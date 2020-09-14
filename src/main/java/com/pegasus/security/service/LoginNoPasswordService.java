package com.pegasus.security.service;

import com.pegasus.security.authentication.oauth.UsernameNoPasswordClientAuthenticationDetails;
import com.pegasus.security.authentication.provider.dao.UsernameNoPasswordAuthenticationToken;
import com.pegasus.security.dto.AuthenticationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by enHui.Chen on 2020/9/14.
 */
@Slf4j
public class LoginNoPasswordService extends LoginService {
    private final AuthenticationManager authenticationManager;
    private final ClientDetailsService clientDetailsService;

    public LoginNoPasswordService(TokenGranter tokenGranter, ClientDetailsService clientDetailsService,
                                  OAuth2RequestFactory oAuth2RequestFactory, AuthenticationManager authenticationManager) {
        super(tokenGranter, clientDetailsService, oAuth2RequestFactory);
        this.clientDetailsService = clientDetailsService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResult getOauth2AccessToken(HttpServletRequest request) {
        // 1.对用户名进行认证
        this.attemptAuthentication(request);
        // 2.对客户端信息进行认证,返回token
        OAuth2AccessToken oauth2AccessToken = this.createOauth2AccessToken(request);
        // 3.构造自定义认证结果
        AuthenticationResult authenticationResult = new AuthenticationResult();
        authenticationResult.authenticateSuccess().setOauth2AccessToken(oauth2AccessToken);
        return authenticationResult;
    }

    @Override
    public void attemptAuthentication(HttpServletRequest request) {
        String username = request.getParameter("username");

        Authentication userAuth = new UsernameNoPasswordAuthenticationToken(username, "");

        ((AbstractAuthenticationToken) userAuth).setDetails(new UsernameNoPasswordClientAuthenticationDetails(request));

        try {
            userAuth = this.authenticationManager.authenticate(userAuth);
        } catch (Exception e) {
            log.error("auth failed:", e);
        }

        SecurityContextHolder.getContext().setAuthentication(userAuth);
    }

    @Override
    public OAuth2AccessToken createOauth2AccessToken(HttpServletRequest request) {
        String clientId = request.getParameter("client_id");

        ClientDetails authenticatedClient = clientDetailsService.loadClientByClientId(clientId);

        Map<String, String> parameters = this.extractParameters(request);
        TokenRequest tokenRequest = getoAuth2RequestFactory().createTokenRequest(parameters, authenticatedClient);

        return getTokenGranter().grant(tokenRequest.getGrantType(), tokenRequest);
    }
}
