package com.cimb.secure.service;

import com.cimb.secure.domain.User;
import com.cimb.secure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServce implements IService<User> {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User user) {
        final String bcryptPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(bcryptPassword);
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteById(Long id) {
        boolean isDelete = false;
        try {
            userRepository.deleteById(id);
            isDelete = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDelete;
    }
}
