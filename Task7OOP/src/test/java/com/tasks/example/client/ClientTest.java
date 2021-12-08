package com.tasks.example.client;

import com.tasks.example.entity.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.channels.SocketChannel;

public class ClientTest {
    private Client clientTest;
    private final Car car = new Car("Renault", 2009, "France");
    private SocketChannel clientSocket = Mockito.mock(SocketChannel.class);

    @Before
    public void setUp(){
        clientTest = new Client(clientSocket);
    }

    @Test
    public void testSendObject() throws IOException, ClassNotFoundException {
        clientTest.sendCar(car);
        clientTest.getBuffer().rewind();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(clientTest.getBuffer().array()));
        Assert.assertEquals(car, ois.readObject());
    }
}