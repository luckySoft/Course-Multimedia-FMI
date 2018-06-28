
package com.cvmanager.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "periods")
public class PeriodEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false, length = 45)
    private String from;
    @Column(nullable = false, length = 45)
    private String to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
