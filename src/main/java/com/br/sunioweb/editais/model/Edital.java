package com.br.sunioweb.editais.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Edital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String number;

    @Lob
    @Column(name="description", columnDefinition = "text")
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm",timezone = "GMT-3")
    private Date datePublication;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm",timezone = "GMT-3")
    private Date dateLastUpdate;

    //disponibilidade
    private boolean disponibility;

    private boolean visibility;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private User user;

    public Edital(long codEdital){
        this.id = codEdital;
    }

    public Edital(String name, String number)
    {
        this.name = name;
        this.number = number;
    }

    public Edital(Long id, String name, String number)
    {
        this.name = name;
        this.number = number;
        this.id = id;
    }
}
