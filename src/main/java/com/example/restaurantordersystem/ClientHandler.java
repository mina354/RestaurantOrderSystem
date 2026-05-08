/*
 * Handles communication with one connected client.
 * Each client runs in its own thread.
 */

package com.example.restaurantordersystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler
        implements Runnable {

    private Socket socket;

    private BufferedReader in;

    private PrintWriter out;

    private RestaurantService
            restaurantService;

    public ClientHandler(
            Socket socket,
            RestaurantService
                    restaurantService) {

        this.socket = socket;

        this.restaurantService =
                restaurantService;

        try {

            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );

            out = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

        } catch (IOException e) {

            System.out.println(
                    "Error creating streams: "
                            + e.getMessage()
            );
        }
    }

    @Override
    public void run() {

        System.out.println(
                "Client handler started."
        );

        String message;

        try {

            while ((message =
                    in.readLine()) != null) {

                handleMessage(message);
            }

        } catch (IOException e) {

            System.out.println(
                    "Client disconnected."
            );
        }

        finally {

            try {

                if (socket != null &&
                        !socket.isClosed()) {

                    socket.close();
                }

            } catch (IOException e) {

                System.out.println(
                        "Error closing socket."
                );
            }
        }
    }

     /*
     * Processes commands received from the client.
     */
    private void handleMessage(
            String message) {

        if (message == null ||
                message.trim().isEmpty()) {

            out.println(
                    "Empty command received."
            );

            return;
        }

        System.out.println(
                "Received: " + message
        );

        if (message.startsWith(
                Protocol.LOGIN)) {

            out.println(
                    "Login successful."
            );
        }

        else if (message.startsWith(
                Protocol.GET_MENU)) {

            out.println(
                    "MENU_START"
            );

            for (MenuItem item :
                    restaurantService
                            .getMenu()
                            .getMenuItems()) {

                out.println(
                        item.getDetails()
                );
            }

            out.println(
                    "MENU_END"
            );
        }

        else if (message.startsWith(
                Protocol.PLACE_ORDER)) {

            try {

                String[] parts =
                        message.split(":");

                if (parts.length < 2) {

                    out.println(
                            "Missing table ID."
                    );

                    return;
                }

                int tableId =
                        Integer.parseInt(
                                parts[1]
                        );

                out.println(
                        "Order received for table "
                                + tableId
                );

            } catch (
                    NumberFormatException e) {

                out.println(
                        "Invalid table number."
                );
            }
        }

        else {

            out.println(
                    "Unknown command."
            );
        }
    }

    public void sendMessage(
            String message) {

        if (message != null &&
                !message.trim().isEmpty()) {

            out.println(message);

            System.out.println(
                    "Sent: " + message
            );
        }
    }
}