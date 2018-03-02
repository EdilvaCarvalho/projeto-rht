
package br.edu.ifpb.projeto.rht.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public interface Command {
    
    public void execute(HttpServletRequest request, HttpServletResponse response);
}
