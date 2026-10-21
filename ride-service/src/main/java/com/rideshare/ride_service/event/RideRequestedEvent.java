package com.rideshare.ride_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Event: publish to Kafka when a rider is required.
 * Matching service consumes this event.
 * TOPIC: ride.requested
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RideRequestedEvent {

    private String rideId;
    private String riderId;

    //PICKUP
    private double pickupLatitude;
    private double pickupLongitude;
    private String pickupAddress;

    //DROP
    private double dropLatitude;
    private double dropLongitude;
    private String dropAddress;

}
