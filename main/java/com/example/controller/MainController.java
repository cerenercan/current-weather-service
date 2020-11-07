package com.example.controller;

import com.example.resources.General;
import com.example.resources.Main;
import com.example.resources.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/city")
public class MainController {

    //api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

    @Value("da01068281b8a228515a59a6631eccb8")
    private String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    URI uri;

    @GetMapping("/{name}")
    public General getCityInfo(@PathVariable("name") String name){

        try{
            String url = "api.openweathermap.org/data/2.5/weather?units=metric&q="+
                    name + "&appid=" + apiKey;

            uri = new URI(url);

        } catch (URISyntaxException e){
            e.getMessage();
        }

        Weather weather = restTemplate.getForObject(uri, Weather.class);
        Main main = restTemplate.getForObject(uri, Main.class);
        return new General(main, weather);

    }

}
