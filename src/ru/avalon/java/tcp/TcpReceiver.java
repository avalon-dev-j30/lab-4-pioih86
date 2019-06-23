package ru.avalon.java.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import jdk.internal.org.xml.sax.InputSource;

/**
 * Упражнение на выаботку умений связанных с получением сообщений,
 * отправленных с использованием протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpReceiver {

    public static void main(String[] args) throws IOException {
        // 1. Определяем порт, на котором ожидается соединение.
        final int port = 10000;
        // 2. Подготавливаем серверный сокет.
        final ServerSocket listener = prepareServerSocket(port);
        // 3. Принимаем соединение.
        Socket socket = listener.accept();
        // 4. Полочаем сообщение.
        final String message = receive(socket);
        // 5. Выводим сообщение.
        System.out.println(message);
        // 6. Закрываем соединение.
        socket.close();
        // 7. Закрываем серверный сокет.
        listener.close();
    }

    /**
     * Возвращает серверный сокет, связанный с портом, описанным
     * параметром {@code port}.
     *
     * @param port порт, на котором предполагается получать входящие
     *             соединения.
     *
     * @return серверный сокет, связанный с портом {@code port}.
     */
    private static ServerSocket prepareServerSocket(int port) throws IOException {
        /*
         * TODO Реализовать метод prepareServerSocket класса TcpReceiver
         */
//        WHY FABRIC NOT "NEW"?
//        SocketAddress address = InetSocketAddress.createUnresolved("localhost", port); 
//        SocketAddress address = new InetSocketAddress("localhost", port);
        ServerSocket socket = new ServerSocket(port);
        return socket;
    }

    /**
     * Возвращает сообщение, прочитанное из входящего потока,
     * указанного сокета.
     *
     * @param socket сокет, описывающий сетевое соединение.
     *
     * @return строковое сообщение.
     */
    private static String receive(Socket socket) throws IOException {
        /*
         * TODO Реализовать метод receive класса TcpReceiver
         */
        InputStream input = socket.getInputStream();
        Reader reader = new InputStreamReader(input);
        BufferedReader in = new BufferedReader(reader);
        String str;
        str = in.readLine();
        return str;
    }
}
