package com.example.retrofit.services;


import com.example.dtos.TextDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TextService {
	
	@GET("/")
    Call<TextDto> getText();

}
