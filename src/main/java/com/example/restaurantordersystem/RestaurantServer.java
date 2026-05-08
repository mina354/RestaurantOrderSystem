/*
 * Main server class responsible for:
 * - accepting client connections
 * - creating client handler threads
 * - managing restaurant service access
 */

package com.example.restaurantordersystem;

import java.net.ServerSocket;
import java.net.Socket;

public class RestaurantServer {

    public static void main(
            String[] args) {
         /*
         * Starts the restaurant server
         * and waits for client connections.
         */
        startServer();
    }

    public static void startServer() {

        RestaurantService
                restaurantService =
                new RestaurantService();

        try {

            ServerSocket serverSocket =
                    new ServerSocket(12345);

            System.out.println(
                    "Restaurant Server started..."
            );

            while (true) {

                Socket clientSocket =
                        serverSocket.accept();

                System.out.println(
                        "Client connected."
                );

                ClientHandler handler =
                        new ClientHandler(
                                clientSocket,
                                restaurantService
                        );

                Thread thread =
                        new Thread(handler);

                thread.start();
            }

        } catch (Exception e) {

            System.out.println(
                    "Server error: "
                            + e.getMessage()
            );
        }
    }
}