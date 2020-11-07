package com.example.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", feels_like='" + feels_like + '\'' +
                ", temp_min='" + temp_min + '\''  +
                ", temp_max='" + temp_max + '\''  +
                '}';
    }
}
