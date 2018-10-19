package de.awtools.schoolplanner.security;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_ref")
    private User user;

    @NotNull
    @Column(name = "login")
    private LocalDateTime login;

    @Null
    @Column(name = "logout")
    private LocalDateTime logout;

    @NotNull
    @Column(name = "token")
    private String token;

    @NotNull
    @Column(name = "sessionId")
    private String sessionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
