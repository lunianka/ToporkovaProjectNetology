package ru.netology.toporkova.service;

import org.springframework.stereotype.Service;
@Service
public class DashboardService {
    private AvatarsService avatarsService;

    public DashboardService(AvatarsService avatarsService) {
        this.avatarsService = avatarsService;
    }
}
