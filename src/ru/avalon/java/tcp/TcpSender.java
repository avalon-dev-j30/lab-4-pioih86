package ru.avalon.java.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Упражнение на выработку базовых умений использования
 * протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpSender {

    public static void main(String[] args) throws IOException {
        // 1. Подготавливааем сообщение
        final String message = prepareMessage();
        // 2. Подготавливаем адрес
        final SocketAddress address = prepareAddress();
        // 3. Устанавливаем соединение
        Socket socket = connect(address);
        // 4. Отправляем сообщение
        send(socket, message);
        // 5. Закрываем соединеие
        System.out.println(socket.isConnected());
        socket.close();
    }

    /**
     * Возвращает объект сообщения.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        /*
         * TODO Реализовать метод prepareMessage класса TcpSender
         */
        String msg = "Hello over TCP";
        return msg;
    }

    /**
     * Возвращает адрес, на который будет выполнена отправка сообщения.
     *
     * @return экземпля типа {@link SocketAddress}
     */
    private static SocketAddress prepareAddress() {
        /*
         * TODO Реализовать метод prepareAddress класса TcpSender
         */
        SocketAddress addr = new InetSocketAddress("localhost", 10000);
        return addr;
    }

    /**
     * Устанавливает соединение на указанный адрес и возвращает сокет
     * описывающий соединение.
     *
     * @param address адрес, на который будет выполено соединение.
     *
     * @return сокет, описывающий открытое соединеие.
     *
     * @throws IOException
     */
    private static Socket connect(SocketAddress address) {
        /*
         * TODO Реализовать метод connect класса TcpSender
         */
            Socket socket = new Socket();
            try {
                socket.connect(address);
            } catch (IOException e) {
                System.err.println("Failed to connect");
            }
            return socket;
                
    }

    /**
     * Выполняет отправку сообщения {@code message} на {@code socket}.
     *
     * @param socket соединение, через которое будет отправлено сообщение.
     * @param message сообщение
     *
     * @throws IOException
     */
    private static void send(Socket socket, String message) throws IOException {
        /*
         * TODO Реализовать метод send класса TcpSender
         */
        OutputStream stream = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        writer.write(message);
        writer.flush();
//        stream.close();
    }

}
