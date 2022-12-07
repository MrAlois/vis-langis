package cz.asenk.vsb.langis.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import cz.asenk.vsb.langis.jpa.model.User;
import cz.asenk.vsb.langis.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Alois Šenkyřík asenkyrik@monetplus.cz
 * @version 1.0
 * Created: 07.12.2022
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    final UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Long countAllUsers(){
        return userRepository.count();
    }

    public void saveUser(@NotNull User user) {
        userRepository.save(user);
    }

    public void deleteUser(String login){
        userRepository.deleteById(login);
    }
}
