package ru.netology.toporkova.service;

import org.springframework.stereotype.Service;
@Service
public class ClientService {
    private AvatarsService avatarsService;

    public ClientService(AvatarsService avatarsService) {
        this.avatarsService = avatarsService;
    }
    public String getClient() {
        return "ClientName " + avatarsService.getAvatar();
    }
}
