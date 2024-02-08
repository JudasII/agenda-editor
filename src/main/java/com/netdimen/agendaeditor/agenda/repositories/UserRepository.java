package com.netdimen.agendaeditor.agenda.repositories;

import com.netdimen.agendaeditor.agenda.models.User.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
