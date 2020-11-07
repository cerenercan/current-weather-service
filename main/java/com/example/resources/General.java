package com.example.resources;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class General {

    private String name;
    private Main main;
    private Weather weather;

    public General(Main main, Weather weather) {

    }
}
