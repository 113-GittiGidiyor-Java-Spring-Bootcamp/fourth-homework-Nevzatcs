package dev.patika.hw04.model;

import dev.patika.hw04.model.enumaration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int courseCode;
    private long studentId;
    private LocalDateTime transactionDataTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}