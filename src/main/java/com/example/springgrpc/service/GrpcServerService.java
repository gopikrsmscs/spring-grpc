package com.example.springgrpc.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GrpcServerService extends com.example.springgrpc.lib.GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void sayHello(com.example.springgrpc.lib.HelloRequest req, StreamObserver<com.example.springgrpc.lib.HelloResponse> responseObserver) {
        com.example.springgrpc.lib.HelloResponse reply = com.example.springgrpc.lib.HelloResponse.newBuilder().setMessage("Hello ==> " + req.getAuthor()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}