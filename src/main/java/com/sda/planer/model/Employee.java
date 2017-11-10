package com.sda.planer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Department department;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "attendees")
    private List<Meeting> meetings;

    public String formattedDepartment(){
        return StringUtils.capitalize(this.department.toString().toLowerCase());
    }

}
