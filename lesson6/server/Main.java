package com.company.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Main implements InteractionClient {
    private Vector<ClientHandler> clients;

    public Main() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                clients.add(new ClientHandler(socket, this, this));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsgToClient(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg("client: " + msg);
        }
    }

    @Override
    public void closeSocket(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }
}
