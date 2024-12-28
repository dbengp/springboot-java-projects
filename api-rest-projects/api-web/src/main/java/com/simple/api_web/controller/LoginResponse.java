package com.simple.api_web.controller;

public record LoginResponse(String accessToken, Long expiresIn) { }
