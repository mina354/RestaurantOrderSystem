/*
 * Singleton client responsible for:
 * - connecting to the server
 * - sending messages
 * - receiving responses
 */
package com.example.restaurantordersystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkClient {

    private static NetworkClient instance;

    private Socket socket;

    private PrintWriter out;

    private BufferedReader in;

    private NetworkClient() {

    }

    public static NetworkClient getInstance() {

        if (instance == null) {

            instance =
                    new NetworkClient();
        }

        return instance;
    }

     /*
     * Connects the client to the restaurant server.
     */
    public void connect() {

        try {

            if (socket != null &&
                    socket.isConnected()) {

                return;
            }

            socket =
                    new Socket(
                            "localhost",
                            12345
                    );

            out =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true
                    );

            in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );

            System.out.println(
                    "Connected to server."
            );

        } catch (Exception e) {

            System.out.println(
                    "Connection failed: "
                            + e.getMessage()
            );
        }
    }

    public boolean isConnected() {

        return socket != null
                && socket.isConnected()
                && !socket.isClosed();
    }

     /*
     * Sends a command/message to the server.
     */
    public void sendMessage(
            String message) {

        if (out == null) {

            System.out.println(
                    "Not connected to server."
            );

            return;
        }

        if (message != null &&
                !message.trim().isEmpty()) {

            out.println(message);

            System.out.println(
                    "Sent: " + message
            );
        }
    }

    public String receiveMessage() {

        try {

            if (in != null) {

                return in.readLine();
            }

        } catch (Exception e) {

            System.out.println(
                    "Receive error: "
                            + e.getMessage()
            );
        }

        return null;
    }

    public void disconnect() {

        try {

            if (socket != null) {

                socket.close();
            }

        } catch (Exception e) {

            System.out.println(
                    "Disconnection error: "
                            + e.getMessage()
            );
        }
    }
}