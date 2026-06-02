package com.backend.model;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_user")
public class User implements Serializable {

    private static final long serialVersionUID = 9223372036854775807L;

    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String address;

}
