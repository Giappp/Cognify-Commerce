package org.rap.cognifycommerce.auth.infrastructure.constants;

public class SecurityConstants {
    public static final String[] BYPASS_ENDPOINTS = {
            "/api/healthcheck/health",
            "/api/v1/auth/signIn",
            "/api/v1/auth/signUp",
            "/api/v1/auth/refresh",
            "/api/v1/auth/verify-email",
            "/api/v1/auth/reset-password",
            "/api/v1/auth/change-password",
            "/api/v1/auth/forgot-password",

            // Swagger endpoints (OpenAPI 3 with springdoc)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/webjars/**"
    };
}
