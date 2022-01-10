package com.worf.worf.repository;

import org.springframework.stereotype.Component;

/**
 * Use it as DI purposes. later implement this using the service
 */
@Component
public interface GameManagerRepository {

    boolean isGameOver();
}
