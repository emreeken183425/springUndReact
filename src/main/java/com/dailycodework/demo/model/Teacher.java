package com.dailycodework.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String lesson;
// Getter  methodlari

    public  Long getId(){
        return id;
    }


    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getLesson(){
        return lesson;
    }


    //Setter methodalari
    public void setId(Long id){
        this.id=id;

    }
    public void setName(String name ){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setLesson(String lesson){
        this.lesson=lesson;
    }

}
