package com.rideshare.location_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DriverLocationRequest{
    private String driverId;
    private double latitude;
    private double longitude;
}
