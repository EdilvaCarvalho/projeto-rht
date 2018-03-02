package br.edu.ifpb.projeto.rht.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class GrauDeLideranca implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        
        String resposta = resultado(request);
        
        request.setAttribute("mensagem", resposta);
        
        try {
            request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(GrauDeLideranca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GrauDeLideranca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String resultado(HttpServletRequest request) {
        String[] telefones = request.getParameterValues("grau");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(telefones));
        
        List<Integer> listaInt = new ArrayList<>();
        
        for (String s : lista) {
            listaInt.add(Integer.valueOf(s));
        }
        
        int soma = 0;
        
        for (Integer grau : listaInt) {
            soma += grau;
        }
        
        int result = soma/30;
        
        if(result >= 3) {
            return "Você está no caminho da liderança.";
        }else {
            return "Compre uma bússola.";
        }
    }

}
