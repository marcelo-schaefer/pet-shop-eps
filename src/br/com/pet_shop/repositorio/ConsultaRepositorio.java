package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.repositorio.interfaces.ConsultaRepositorioInterface;

import java.util.List;
import java.util.Optional;

public class ConsultaRepositorio implements ConsultaRepositorioInterface {

	@Override
	public Boolean criar(Consulta entidade) {
		return null;
	}

	@Override
	public Boolean atualizar(Consulta entidade) {
		return null;
	}

	@Override
	public Optional<Consulta> buscarPorId(Integer id) {
		return Optional.empty();
	}

	@Override
	public Consulta buscarUltimo() {
		return null;
	}

	@Override
	public List<Consulta> buscar() {
		return null;
	}

	@Override
	public Boolean deletar() {
		return null;
	}

	@Override
	public Boolean deletarPorId(Integer id) {
		return null;
	}

	@Override
	public Boolean existePorID(Integer id) {
		return null;
	}
}
