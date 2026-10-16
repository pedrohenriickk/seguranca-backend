package com.example.seguranca.Repositories;

import com.example.seguranca.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {


    Cliente findByEmail(String email);
}
