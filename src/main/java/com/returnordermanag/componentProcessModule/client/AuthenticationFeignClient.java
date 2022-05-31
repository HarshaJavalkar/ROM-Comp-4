package com.returnordermanag.componentProcessModule.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnordermanag.componentProcessModule.model.AuthenticationResponse;


//@FeignClient(name = "authenticationFeignClient", url = "${AUTH_URI:localhost:8084}")
@FeignClient(name = "authenticationFeignClient")
public interface AuthenticationFeignClient {

	@GetMapping(value = "/validate")
	AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);
}
