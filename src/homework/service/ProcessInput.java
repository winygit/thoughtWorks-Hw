package homework.service;

import homework.exception.HomeWorkException;

public interface ProcessInput {

    /*
     * process input  line by line
     */
    String parse(String inputLine) throws HomeWorkException;
}
