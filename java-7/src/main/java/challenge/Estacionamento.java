package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {

        validaCarro(carro);
        validaMotorista(carro.getMotorista());
        organizaVagas();
        carrosEstacionados.add(carro);
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.stream()
                .anyMatch(c -> c.getPlaca().equals(carro.getPlaca())
                        && c.getMotorista().equals(carro.getMotorista()));
    }

    public void validaCarro(Carro carro) {
        if (carro.getCor() == null || carro.getPlaca() == null || carro.getMotorista() == null)
            throw new NullPointerException();
    }

    public void validaMotorista(Motorista motorista) {
        if (motorista.getPontos() > 20 || motorista.getIdade() < 18)
            throw new EstacionamentoException("Motorista não pode dirigir!");
    }

    public void organizaVagas() {
        if(carrosEstacionados() == 10) {
            for (Carro carro : carrosEstacionados) {
                if (carro.getMotorista().getIdade() > 55)
                    continue;
                else {
                    carrosEstacionados.remove(carro);
                    break;
                }
            }
            if(carrosEstacionados() == 10) throw new EstacionamentoException("Estacionamento lotado!");
        }
    }
}
