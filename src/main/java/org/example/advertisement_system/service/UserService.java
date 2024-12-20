package org.example.advertisement_system.service;

import org.example.advertisement_system.entity.AdvHost;
import org.example.advertisement_system.mapper.AdvHostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AdvHostMapper advHostMapper;

    public AdvHost authenticate(String username, String password) {
        AdvHost advHost = advHostMapper.findByAdvHostName(username);
        if (advHost != null && advHost.getPassword().equals(password)) {
            return advHost;
        }
        return null;
    }

    public boolean register(AdvHost advHost) {
        // 检查用户名是否已存在
        if (advHostMapper.findByAdvHostName(advHost.getUsername()) != null) {
            return false;
        }
        // 插入新用户
        advHostMapper.insertAdvHost(advHost);
        return true;
    }
}
