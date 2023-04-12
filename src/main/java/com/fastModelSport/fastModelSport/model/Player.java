package com.fastModelSport.fastModelSport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor

public class Player {
    private String name;
    private String height;
    private int number;
    private LocalDate birthdate;

    @JsonProperty("PTS")
    private int pts;

    @JsonProperty("Reb")
    private int reb;

    @JsonProperty("AST")
    private int ast;

    @JsonProperty("TO")
    private int to;
    private int fastStat;

}