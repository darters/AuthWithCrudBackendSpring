package com.example.demo.security;

import java.security.SecureRandom;
import java.util.Base64;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/api/auth/**";
    public static final String SECRET = "hDavKVnVweZhPoZn77Si9ADrDMlmisqxZch08gGEOCu+DvCQbP8E04khODI4zyP/P4FTMIxjsmt5w1XzuQV0sQ==";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000;
}