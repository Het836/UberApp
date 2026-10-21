package com.rideshare.ride_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Who requested the ride?
    @Column(nullable = false)
    private String riderId;

    private String driverId;

    @Column(nullable = false)
    private double pickupLatitude;
    @Column(nullable = false)
    private double pickupLongitude;

    @Column(nullable = false)
    private String pickupAddress;

    @Column(nullable = false)
    private double dropLatitude;
    @Column(nullable = false)
    private double dropLongitude;

    @Column(nullable = false)
    private String dropAddress;

    // Right status - Track the life cycle.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RideStatus status;

    // Fare details.
    private double estimatedFare;
    private double actualFare;

    // Timestamps
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

}
