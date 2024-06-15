package com.SA.StudyApp.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "client")
public class Client extends User{
    public Client(User user){
        super(user);
    }
}
