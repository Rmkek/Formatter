package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Interface for all commands.
 */
public interface ICommand {
    /**
     * Method for executing command.
     * @param writer where execution output will be written.
     */
    void execute(IWriter writer);
}
