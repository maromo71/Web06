package br.santalucia.web04times.servlet;

import br.santalucia.web04times.dao.JogadorDao;
import br.santalucia.web04times.model.Jogador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TimeServlet", value = "/time")
public class TimeServlet extends HttpServlet {

    List<Jogador> lista = new ArrayList<>();

    //Método para adicionar no time
    public void adicionarNoTime(Jogador jogador) throws ClassNotFoundException {
        lista.add(jogador);
        JogadorDao jogadorDao = new JogadorDao();
        jogadorDao.adicionarJogador(jogador);
    }
    //método para listar os jogadores do time
    public List<Jogador> listaDeJogadores() throws ClassNotFoundException {
        JogadorDao jogadorDao = new JogadorDao();
        try {
            return jogadorDao.listarJogadores();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Times</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Times do Brasil</h1>");
        response.getWriter().println("<h2>Palmeiras</h2>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jogador jogador = new Jogador();
        jogador.setNome(request.getParameter("nomeJogador"));
        jogador.setApelido(request.getParameter("apelidoJogador"));
        jogador.setPosicao(request.getParameter("posicaoJogador"));
        jogador.setIdade(Integer.parseInt(request.getParameter("idadeJogador")));
        try {
            this.adicionarNoTime(jogador);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Dados Cadastrados</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Jogador Cadastrado com Sucesso</h2>");
        try {
            for (Jogador j : this.listaDeJogadores()) {
                response.getWriter().println("<p>Nome do Jogador: " + j.getNome() + "</p>");
                response.getWriter().println("<p>Apelido do Jogador: " + j.getApelido() + "</p>");
                response.getWriter().println("<p>Posição do Jogador: " + j.getPosicao() + "</p>");
                response.getWriter().println("<p>Idade do Jogador: " + j.getIdade() + "</p>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().println("</body>");
        response.getWriter().println("</html");
    }
}
