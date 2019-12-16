package ru.mailow;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Callable<T> callable;
    private volatile Boolean finished = false;
    private T result;
    private RuntimeException exception;

    public Task (Callable<T> callable) {this.callable = callable;}

    public T get() {


            if(!finished){
                try{
                    result = callable.call();
                }catch(Exception e){
                    exception = new RuntimeException(e);
                }finally {
                    finished = true;
                }
            }



    if(exception != null)throw exception;
    return result;
}
}
