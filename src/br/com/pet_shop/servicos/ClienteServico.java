package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.ClienteRepositorio;
import br.com.pet_shop.servicos.interfaces.AnimalServicoInterface;
import br.com.pet_shop.servicos.interfaces.ClienteServicoInterface;
import br.com.pet_shop.tela.entidades.ClienteTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.ClienteMensagem;

public class ClienteServico implements ClienteServicoInterface {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente criar() {
        var cliente = ClienteTela.criar();
        clienteRepositorio.criar(cliente);

        return clienteRepositorio.criar(cliente);
    }

    public Cliente atualizar() {
        var cliente = ClienteTela.atualizar();
        var clienteId = cliente.getId();

        var existeCliente = clienteRepositorio.existePorID(clienteId);

        if (existeCliente.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    ClienteMensagem.NAO_ENCONTRADO,
                    clienteId
                )
            );
        }
        clienteRepositorio.atualizar(cliente);

        return clienteRepositorio.buscarPorId(clienteId).get();
    }

    public Cliente buscarPorId() {
        var cliente = ClienteTela.buscar();
        var clienteId = cliente.getId();

        return clienteRepositorio.buscarPorId(clienteId).orElseThrow(
            () -> new EntidadeNaoEncontrada(
                String.format(
                    ClienteMensagem.NAO_ENCONTRADO,
                    clienteId
                )
            )
        );
    }

    public Boolean deletarPorId() {
        var cliente = ClienteTela.deletar();

        clienteRepositorio.deletarPorId(cliente.getId());

        return Boolean.TRUE;
    }
}
