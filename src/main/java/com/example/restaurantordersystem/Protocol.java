/*
 * Contains protocol commands exchanged
 * between client and server.
 */

package com.example.restaurantordersystem;

public class Protocol {

    public static final String LOGIN = "LOGIN";

    public static final String PLACE_ORDER = "PLACE_ORDER";

    public static final String GET_MENU = "GET_MENU";

    public static final String ORDER_UPDATE = "ORDER_UPDATE";

    public static final String BROADCAST = "BROADCAST";

    private Protocol() {
        // Prevent object creation
    }
}