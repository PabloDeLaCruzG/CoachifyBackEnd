package com.pablodelacruz.coachify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.Usuario;
import com.pablodelacruz.coachify.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Updates an existing user with the provided details.
     *
     * @param id The ID of the user to update.
     * @param usuarioDetails The details of the user to update with.
     * @return The updated user, or null if the user does not exist.
     */
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        // Find the user with the provided ID
        return usuarioRepository.findById(id)
                // If the user exists, update its details and save the updated user
                .map(existingUsuario -> {
                    // Set the mail of the existing user with the mail from the provided details
                    existingUsuario.setMail(usuarioDetails.getMail());
                    // Set the telefono of the existing user with the telefono from the provided details
                    existingUsuario.setTelefono(usuarioDetails.getTelefono());
                    // Set the nombreUsuario of the existing user with the nombreUsuario from the provided details
                    existingUsuario.setNombreUsuario(usuarioDetails.getNombreUsuario());
                    // Set the contrasena of the existing user with the contrasena from the provided details
                    existingUsuario.setContrasena(usuarioDetails.getContrasena());
                    // Save the updated user and return it
                    return usuarioRepository.save(existingUsuario);
                })
                // If the user does not exist, return null
                .orElse(null);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
