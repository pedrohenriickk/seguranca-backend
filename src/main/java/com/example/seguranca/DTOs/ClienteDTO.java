package com.example.seguranca.DTOs;

import com.example.seguranca.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private String nome;
    private String email;
    private String senha;
    private Role role;

    public ClienteDTO(String nome, String email, String senha, Role role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }
}
