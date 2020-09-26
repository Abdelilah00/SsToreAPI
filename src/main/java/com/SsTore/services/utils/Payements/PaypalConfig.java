package com.SsTore.services.utils.Payements;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfig {
    @Value("${paypal.client.id}")
    private String clientId;
    @Value("${paypal.client.secret}")
    private String clientSecret;
    @Value("${paypal.mode}")
    private String mode;

    @Bean
    public Map<String, String> PaypalSdkConfig() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("mode", mode);
        return configMap;
    }

    @Bean
    public OAuthTokenCredential OAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, PaypalSdkConfig());
    }

    @Bean
    public APIContext ApiContext() throws PayPalRESTException {
        APIContext context = new APIContext(OAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(PaypalSdkConfig());
        return context;
    }
}
