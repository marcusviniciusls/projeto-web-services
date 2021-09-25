package br.com.educandoweb.projetowebservices.services.exceptions;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(Object id){
        super("Resource not found. ID " + id);
    }
}
