package com.example.seguranca.services;

import com.example.seguranca.DTOs.ClienteDTO;
import com.example.seguranca.Entities.Cliente;
import com.example.seguranca.Entities.Role;
import com.example.seguranca.Repositories.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ClienteService {
    private final PasswordEncoder passwordEncoder;
    private final ClienteRepository clienteRepository;


    public ClienteService(PasswordEncoder passwordEncoder, ClienteRepository clienteRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clienteRepository = clienteRepository;
    }

    public String criarCliente(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setEmail(dto.getEmail());
        cliente.setNome(dto.getNome());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));
        clienteRepository.save(cliente);
        if (dto.getRole() == null){
            cliente.setRole(Role.ROLE_USER);
        }else{
            cliente.setRole(dto.getRole());
        }

        return "Cliente cadastrado com sucesso";

    }




}
