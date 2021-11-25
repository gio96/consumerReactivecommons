package com.example.subscriber;

import org.reactivecommons.api.domain.Command;
import org.reactivecommons.api.domain.DomainEvent;
import reactor.core.publisher.Mono;


public class ManageTasksUseCase {


    public Mono<Void> functionReturningMonoVoid(DomainEvent<TestEvent> event) {
        return Mono.just(event)
                //.log()
                .doOnNext(algo -> System.out.println(algo.getData()))
                .then();
    }

    public Mono<Void> createTask(Command<TestCommand> cmd) {
        return Mono.just(cmd.getData())
                .doOnNext(System.out::println)
                .then();
    }

    public Mono<String> findSomething(String s) {
        return Mono.just(s)
                .doOnNext(System.out::println)
                .thenReturn(s.concat("ya estuve en el suscriptor"));
    }

}
