package com.rideshare.ride_service.service;

import com.rideshare.ride_service.event.RideMatchedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RideEventConsumer {

    private final RideService rideService;

    @KafkaListener(
            topics = "ride.matched",
            groupId = "ride-service-group"
    )
    public void consumeRideMatchedEvent(RideMatchedEvent event) {
        log.info("Consuming ride matched event: {}", event);
        rideService.updateRideWithDriver(event.getRideId(), event.getDriverId());
    }
}
