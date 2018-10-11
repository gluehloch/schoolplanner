package de.awtools.schoolplanner.security;

import java.time.LocalDateTime;

public class Session {

    private Long id;

    private User user;
    private LocalDateTime login;
    private LocalDateTime logout;
    private String token;
    private String sessionId;

}
