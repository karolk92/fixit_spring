package com.sellions.fixit.comment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sellions.fixit.device.entity.Device;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "device")
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "create_timestamp")
    private LocalDateTime createTimestamp;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    @JsonIgnore
    private Device device;
}
