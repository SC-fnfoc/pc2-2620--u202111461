package com.aquamonitor.platform.u202111461.shared.interfaces.rest.resources;

/**
 * Standard error response resource containing a localized message
 * MessageResource
 * @param message the localized error description
 * @author Sebastian Carbajal
 */
public record MessageResource(String message) {}
