package ru.skilanov.ioTest;

import org.junit.Assert;
import org.junit.Test;
import ru.skilanov.io.Server;
import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by Semen on 08.08.2017.
 */
public class ServerTest {

    @Test
    public void whenWeSortFileThenReturnSortedFile()throws IOException{
        Socket socket = mock(Socket.class);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("exit".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(inputStream);
        when(socket.getOutputStream()).thenReturn(outputStream);
        Server server = new Server(socket);
        server.serverAction();
        Assert.assertThat(outputStream.toString(), is(""));
    }
}
