package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> times = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();
	List<Jogador> teamPlayers = new ArrayList<>();


	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		if(id == null || id < 0 || nome == null || dataCriacao == null || corUniformePrincipal == null || corUniformeSecundario == null)
			throw new NullPointerException();

		if(times.stream().anyMatch(t -> t.getId().equals(id)))
			throw new IdentificadorUtilizadoException();

		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);

		times.add(time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome
			, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		if(id == null || id < 0 || idTime == null || idTime < 0 || nome == null || dataNascimento == null || nivelHabilidade == null || salario == null)
			throw new NullPointerException();

		if(nivelHabilidade < 0 || nivelHabilidade > 100)
			throw new IllegalArgumentException();

		if(jogadores.stream().anyMatch(j -> j.getId().equals(id)))
			throw new IdentificadorUtilizadoException();

		if(times.stream().noneMatch(t -> t.getId().equals(idTime)))
			throw new TimeNaoEncontradoException();

		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		jogadores.add(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		Jogador jogadorCapitao = jogadores.stream()
				.filter(j -> j.getId().equals(idJogador))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);

		Time timeCapitao = times.stream()
				.filter(t -> t.getId().equals(jogadorCapitao.getTeamId()))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);

		timeCapitao.setCaptain(jogadorCapitao);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		Time team = times.stream()
				.filter(t -> t.getId().equals(idTime))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);

		return times.stream()
				.filter(t -> Objects.equals(t.getId(), idTime))
				.filter(c -> null != c.getCaptain())
				.findFirst()
				.orElseThrow(CapitaoNaoInformadoException::new)
				.getCaptain()
				.getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

		Jogador jogador = jogadores.stream()
				.filter(j -> j.getId().equals(idJogador))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);

		return jogador.getName();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		Time team = times.stream()
				.filter(t -> t.getId().equals(idTime))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);

		return team.getName();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		
		if(times.stream().noneMatch(t -> t.getId().equals(idTime)))
			throw new TimeNaoEncontradoException();

		return  jogadores.stream()
				.filter(x -> x.getTeamId().equals(idTime))
				.mapToLong(Jogador::getId)
				.sorted()
				.boxed()
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		if(times.stream().noneMatch(t -> t.getId().equals(idTime)))
			throw new TimeNaoEncontradoException();

		return jogadores.stream()
				.filter(j -> j.getTeamId().equals(idTime))
				.sorted(Comparator.comparingInt(Jogador::getSkillLevel)
						.reversed()
						.thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {

		if(times.stream().noneMatch(t -> t.getId().equals(idTime)))
			throw new TimeNaoEncontradoException();

		return jogadores.stream()
				.filter(j -> j.getTeamId().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getBirthDate)
						.thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {

		if(times.isEmpty())
			return new ArrayList<>();

		List<Long> teamIds = new ArrayList<>();

		times.forEach(t -> teamIds.add(t.getId()));

		return teamIds;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {

		if(times.stream().noneMatch(t -> t.getId().equals(idTime)))
			throw new TimeNaoEncontradoException();

		for (Jogador jogador :
				jogadores) {
			if (jogador.getTeamId().equals(idTime))
				teamPlayers.add(jogador);
		}

		return teamPlayers.stream()
				.filter(j -> j.getBirthDate() != null)
				.sorted(Comparator.comparing(Jogador::getSalary)
						.reversed()
						.thenComparingLong(Jogador::getId))
				.filter(x -> x.getTeamId().equals(idTime))
				.map(Jogador::getId).findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		return jogadores.stream()
				.filter(j -> j.getId().equals(idJogador))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new)
				.getSalary();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		if(jogadores.isEmpty())
			return new ArrayList<>();

		List<Jogador> topJogadores = jogadores.stream()
				.sorted(Comparator.comparingInt(Jogador::getSkillLevel).reversed())
				.limit(top)
				.collect(Collectors.toList());

		List<Long> idTopJogadores = new ArrayList<>();

		topJogadores.forEach(tj -> idTopJogadores.add(tj.getId()));

		return  jogadores.stream()
				.sorted(Comparator.comparingInt(Jogador::getSkillLevel)
				.reversed()
				.thenComparingLong(Jogador::getId))
				.limit(top)
				.mapToLong(Jogador::getId)
				.boxed()
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Time timeCasa = times.stream()
				.filter(t -> t.getId().equals(timeDaCasa))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);

		Time timeFora = times.stream()
				.filter(t -> t.getId().equals(timeDeFora))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);

		if(timeCasa.getPrincipalColor().equals(timeFora.getPrincipalColor()))
			return timeFora.getSecondColor();
		else
			return timeFora.getPrincipalColor();
	}

}
