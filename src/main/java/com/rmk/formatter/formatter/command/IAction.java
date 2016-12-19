package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Interface for all actions.
 */
public interface IAction {
    /**
     * Executes action with choosen IWriter.
     * @param writer that will be written to.
     */
    void execute(IWriter writer);
}
