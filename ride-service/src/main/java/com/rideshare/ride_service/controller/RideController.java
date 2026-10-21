package com.rideshare.ride_service.controller;

import com.rideshare.ride_service.dto.RideRequest;
import com.rideshare.ride_service.dto.RideResponse;
import com.rideshare.ride_service.service.RideService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rides")
@Slf4j
@RequiredArgsConstructor
public class RideController {

    private final RideService rideService;

    // Rider requests a new ride.
    @PostMapping("/request")
    public ResponseEntity<RideResponse> requestRide(
            @Valid @RequestBody RideRequest rideRequest
            ) {
        log.info("Ride request received from rider: {}", rideRequest.getRiderId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rideService.requestRide(rideRequest));
    }

    @GetMapping("/{riderId}")
    public ResponseEntity<RideResponse> getRide(
            @PathVariable String riderId
    ){
        return ResponseEntity.ok(rideService.getRideById(riderId));
    }

    @GetMapping("/rider/{riderId}")
    public ResponseEntity<List<RideResponse>> getRidesByRiderId(
            @PathVariable String riderId
    ) {
        return ResponseEntity.ok(rideService.getRidesByRider(riderId));
    }

    // Driver starts the ride.
    @PutMapping("/{rideId}/start")
    public ResponseEntity<RideResponse> startRide(
            @PathVariable String rideId
    ) {
        return ResponseEntity.ok(rideService.startRide(rideId));
    }

    @PutMapping("/{rideId}/complete")
    public ResponseEntity<RideResponse> completeRide(
            @PathVariable String rideId
    ) {
        return ResponseEntity.ok(rideService.completeRide(rideId));


    }@PutMapping("/{rideId}/cancel")
    public ResponseEntity<RideResponse> cancelRide(
            @PathVariable String rideId
    ) {
        return ResponseEntity.ok(rideService.cancelRide(rideId));
    }

}
