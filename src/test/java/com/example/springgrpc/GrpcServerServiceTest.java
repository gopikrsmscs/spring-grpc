package com.example.springgrpc;

import com.example.springgrpc.lib.GreetServiceGrpc;
import com.example.springgrpc.lib.HelloRequest;
import com.example.springgrpc.lib.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GrpcServerServiceTest {
    private ManagedChannel channel;
    private GreetServiceGrpc.GreetServiceBlockingStub blockingStub;

    @Before
    public void setUp() {
        // Create a channel to the server
        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // Use plaintext communication (no encryption)
                .build();

        // Create a blocking stub for synchronous communication
        blockingStub = GreetServiceGrpc.newBlockingStub(channel);
    }

    @After
    public void tearDown() {
        // Shutdown the channel after the test
        channel.shutdownNow();
    }

    @Test
    public void testSayHello() {
        // Prepare the request
        HelloRequest request = HelloRequest.newBuilder()
                .setAuthor("Alice").setUid(1).setMessage("baby")
                .build();

        // Send the request to the server and get the response
        HelloResponse response = blockingStub.sayHello(request);

        // Verify the response
        assertEquals("Hello ==> Alice", response.getMessage());
    }
}