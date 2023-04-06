package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.interfaces.ClienteRepositorioInterface;
import br.com.pet_shop.tela.entidades.ClienteTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.ClienteMensagem;

public class ClienteServico {

    private final ClienteRepositorioInterface clienteRepositorioInterface;

    public ClienteServico(ClienteRepositorioInterface clienteRepositorioInterface) {
        this.clienteRepositorioInterface = clienteRepositorioInterface;
    }

    public Cliente criar() {
        var cliente = ClienteTela.criar();
        clienteRepositorioInterface.criar(cliente);

        return clienteRepositorioInterface.buscarUltimo();
    }

    public Cliente atualizar() {
        var cliente = ClienteTela.atualizar();
        var clienteId = cliente.getId();

        var existeCliente = clienteRepositorioInterface.existePorID(clienteId);

        if (existeCliente.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    ClienteMensagem.NAO_ENCONTRADO,
                    clienteId
                )
            );
        }
        clienteRepositorioInterface.atualizar(cliente);

        return clienteRepositorioInterface.buscarPorId(clienteId).get();
    }

    public Cliente buscarPorId() {
        var cliente = ClienteTela.buscar();
        var clienteId = cliente.getId();

        return clienteRepositorioInterface.buscarPorId(clienteId).orElseThrow(
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

        return clienteRepositorioInterface.deletarPorId(cliente.getId());
    }
}
