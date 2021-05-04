package com.example.vue.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.example.vue.model.JSONResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
    									AuthenticationException exception) throws ServletException, IOException {
		
		// application/json(ajax) 요청일 경우 아래의 처리!
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        MediaType jsonMimeType = MediaType.APPLICATION_JSON;

        JSONResult jsonResult = JSONResult.success("");
        jsonResult.setMessage(exception.getMessage());
        
        if (jsonConverter.canWrite(jsonResult.getClass(), jsonMimeType)) {
            jsonConverter.write(jsonResult, jsonMimeType, new ServletServerHttpResponse(response));
        }
    }
}
